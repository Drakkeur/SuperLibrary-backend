package edu.m2i.api_gestion_bibliotheque.controller;

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
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.service.GestionLoanService;
import edu.m2i.api_gestion_bibliotheque.service.GestionOuvrageService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/loan")
public class GestionLoanController {

	@Autowired
	GestionLoanService gestionLoanService;
	GestionOuvrageService gestionOuvrageService;

	// Récupérer la liste complète des emprunts
	@GetMapping("/loans")
	public List<Loan> getAllLoan() {
		return gestionLoanService.findAll();
	}

	// Récupérer la liste des emprunts d'un utilisateur
	@GetMapping("/loan-user/{id}")
	public List<Loan> getLoanUser(@PathVariable("id") Integer id) {
		return gestionLoanService.getByUser(id);
	}

	// Récupérer la liste des emprunts d'un ouvrage
	@GetMapping("/loan-ouvrage/{id}")
	public List<Loan> getLoanOuvrage(@PathVariable("id") Integer id) {
		return gestionLoanService.getByOuvrage(id);
	}

	// Récupérer la liste des emprunts par status
	@GetMapping("/loan-status")
	public List<Loan> getLoanStatus(@RequestBody String status) {
		return gestionLoanService.getByStatus(status);
	}

	// Récupérer un emprunt par ID
	@GetMapping("/loan/{id}")
	public LoanDTO getLoan(@PathVariable("id") Integer id) {
		return gestionLoanService.findById(id);
	}

	// Faire une réservation
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add-reservation")
	public void addReservation(@Valid @RequestBody LoanDTO request) {
		Loan loan = new Loan();
		loan.setDateStart();
		loan.setTheoreticalDateEnd();
		loan.setStatus(1);
		loan.setOuvrage(request.getOuvrage());
		loan.setUser(request.getUser());
		gestionLoanService.save(loan);
	}

	// Valider une réservation
	@PutMapping("/validate-reservation/{id}")
	public void validateReservation(@PathVariable("id") Integer id) {
		gestionLoanService.changeStatusLoan(id, "En cours");
		LoanDTO loanDTO = gestionLoanService.findById(id);
		Ouvrage ouvrage = loanDTO.getOuvrage();
		gestionOuvrageService.statusOuvrage(ouvrage.getId());
	}

	// Valider un retour d'emprunt
	@PutMapping("/validate-return/{id}")
	public void validateReturn(@PathVariable("id") Integer id) {
		gestionLoanService.changeStatusLoan(id, "Terminé");
		LoanDTO loanDTO = gestionLoanService.findById(id);
		Ouvrage ouvrage = loanDTO.getOuvrage();
		gestionOuvrageService.statusOuvrage(ouvrage.getId());
	}

	// Supprimer un emprunt
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteLoan(@PathVariable("id") Integer id) {
		gestionLoanService.delete(id);
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
