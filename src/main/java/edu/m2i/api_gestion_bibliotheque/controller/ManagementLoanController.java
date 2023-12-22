package edu.m2i.api_gestion_bibliotheque.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.m2i.api_gestion_bibliotheque.dto.LoanDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Loan;
import edu.m2i.api_gestion_bibliotheque.service.ManagementLoanService;
import edu.m2i.api_gestion_bibliotheque.service.ManagementUserService;
import edu.m2i.api_gestion_bibliotheque.service.ManagementWorkService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/loan")
public class ManagementLoanController {

	@Autowired
	ManagementLoanService managementLoanService;
	@Autowired
	ManagementWorkService managementWorkService;
	@Autowired
	ManagementUserService managementUserService;

	// Récupérer la liste complète des emprunts
	@GetMapping("/all")
	public List<Loan> getAllLoan() {
		return managementLoanService.findAll();
	}

	// Récupérer la liste des emprunts d'un utilisateur
	@GetMapping("/loan-user/{id}")
	public List<Loan> getLoanUser(@PathVariable("id") Integer id) {
		return managementLoanService.getByUser(id);
	}

	// Récupérer la liste des emprunts d'un ouvrage
	@GetMapping("/loan-work/{id}")
	public List<Loan> getLoanOuvrage(@PathVariable("id") Integer id) {
		return managementLoanService.getByWork(id);
	}

	// Récupérer la liste des emprunts par status
	@GetMapping("/loan-status/{code}")
	public List<Loan> getLoanStatus(@PathVariable("code") Integer status) {
		return managementLoanService.getByStatus(status);
	}

	// Récupérer un emprunt par ID
	@GetMapping("/loan/{id}")
	public LoanDTO getLoan(@PathVariable("id") Integer id) {
		return managementLoanService.findByIdDTO(id);
	}

	// Faire une réservation
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add-reservation")
	public void addReservation(@Valid @RequestBody LoanDTO request) {
		Loan loan = new Loan();
		loan.setDateStart();
		loan.setTheoreticalDateEnd();
		loan.setStatus(1);
		loan.setWork(managementWorkService.findById(request.getIdWork()));
		loan.setUser(managementUserService.findById(request.getIdUser()));
		managementLoanService.save(loan);
		managementWorkService.statusWork(request.getIdWork());
	}

	// Valider une réservation
	@PutMapping("/validate-reservation/{id}")
	public void validateReservation(@PathVariable("id") Integer id) {
		Loan loan = managementLoanService.findById(id);
		loan.setStatus(2);
		managementLoanService.save(loan);
	}

	// Refuser une réservation
	@DeleteMapping("/refuse-reservation/{id}")
	public void refuseReservation(@PathVariable("id") Integer id) {
		managementLoanService.delete(id);
	}

	// Valider un retour d'emprunt
	@PutMapping("/validate-return/{id}")
	public void validateReturn(@PathVariable("id") Integer id) {
		managementLoanService.findById(id).setStatus(0);
		managementLoanService.findById(id).setRealDateEnd(LocalDate.now());
		managementWorkService.statusWork(managementWorkService.findById(id).getId());
	}

	// Supprimer un emprunt
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteLoan(@PathVariable("id") Integer id) {
		managementLoanService.delete(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> erreurs = new HashMap<>();
		e.getBindingResult().getAllErrors()
				.forEach(err -> erreurs.put(((FieldError) err).getField(), err.getDefaultMessage()));
		return erreurs;
	}
}
