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

import edu.m2i.api_gestion_bibliotheque.dto.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.service.GestionOuvrageService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/ouvrages")
public class GestionOuvrageController {

	@Autowired
	GestionOuvrageService gestionOuvrageService;

	@GetMapping("/all")
	public List<Ouvrage> getAllOuvrages() {
		return gestionOuvrageService.findAll();
	}

	@GetMapping("/{id}")
	public Ouvrage getOuvrage(@PathVariable("id") Integer id) {
		return gestionOuvrageService.findById(id);
	}
	
	@GetMapping("/{filter}")
	public List<Ouvrage> getOuvrage(@PathVariable("filter") String filter){
		return gestionOuvrageService.getOuvrage(filter);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteOuvrage(@PathVariable("id") Integer id) {
		gestionOuvrageService.delete(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addOuvrages(@Valid @RequestBody OuvrageDTO request) {
		Ouvrage ouvrage = new Ouvrage();
		ouvrage.setCote(request.getCote());
		ouvrage.setTitle(request.getTitle());
		ouvrage.setMainAuthor(request.getMainAuthor());
		ouvrage.setOtherAuthor(request.getOtherAuthor());
		ouvrage.setGenre(request.getGenre());
		ouvrage.setEditor(request.getEditor());
		ouvrage.setPublishedDate(request.getPublishedDate());
		ouvrage.setComment(request.getComment());
		ouvrage.setAvailability(request.getAvailability());
		ouvrage.setTypeOuvrage(request.getTypeOuvrage());
		gestionOuvrageService.save(ouvrage);
	}
	
	@GetMapping("change-status/{id}")
	public void statusOuvrage(@PathVariable("id") Integer id) {
		gestionOuvrageService.statusOuvrage(id);
	}
	
	@PutMapping("update/{id}")
	public void updateUser(@PathVariable("id") Integer id, @RequestBody OuvrageDTO request) {
		Ouvrage ouvrage = gestionOuvrageService.findById(id);
		ouvrage.setCote(request.getCote());
		ouvrage.setTitle(request.getTitle());
		ouvrage.setMainAuthor(request.getMainAuthor());
		ouvrage.setOtherAuthor(request.getOtherAuthor());
		ouvrage.setGenre(request.getGenre());
		ouvrage.setEditor(request.getEditor());
		ouvrage.setPublishedDate(request.getPublishedDate());
		ouvrage.setComment(request.getComment());
		ouvrage.setAvailability(request.getAvailability());
		ouvrage.setTypeOuvrage(request.getTypeOuvrage());
		gestionOuvrageService.save(ouvrage);
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
