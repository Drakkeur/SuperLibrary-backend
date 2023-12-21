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

import edu.m2i.api_gestion_bibliotheque.dto.TypeWorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.TypeWork;
import edu.m2i.api_gestion_bibliotheque.service.ManagementTypeWorkService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/type-Work")
public class ManagementTypeWorkController {

	@Autowired
	ManagementTypeWorkService managementTypeWorkService;

	// Récupérer la liste complète des types d'Work
	@GetMapping("/typesWork")
	public List<TypeWork> getAllTypeWork() {
		return managementTypeWorkService.findAll();
	}
	
	@GetMapping("/{id}")
	public TypeWork getTypeWork(@PathVariable("id") Integer id) {
		return managementTypeWorkService.findById(id);
	}

	// Ajouter un nouveau type d'Work
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addTypeWork(@Valid @RequestBody TypeWorkDTO request) {
		TypeWork typeWork = new TypeWork();
		typeWork.setName(request.getName());
		typeWork.setCount(0);
		managementTypeWorkService.save(typeWork);
	}

	// Supprimer un type d'Work
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteTypeWork(@PathVariable("id") Integer id) {
		managementTypeWorkService.delete(id);
	}

	// Modifier un type d'Work déjà présent dans la DB
	@PutMapping("/update/{id}")
	public void updateTypeWork(@PathVariable("id") Integer id, @RequestBody TypeWorkDTO typeWorkDTO) {
		TypeWork typeWork = managementTypeWorkService.findById(id);
		typeWork.setName(typeWorkDTO.getName());
		managementTypeWorkService.save(typeWork);
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
