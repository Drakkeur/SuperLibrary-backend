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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.m2i.api_gestion_bibliotheque.dto.WorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Work;
import edu.m2i.api_gestion_bibliotheque.service.ManagementWorkService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/ouvrages")
public class ManagementWorkController {

	@Autowired
	ManagementWorkService gestionOuvrageService;

	@GetMapping("/all")
	public List<Work> getAllOuvrages() {
		return gestionOuvrageService.findAll();
	}

	@GetMapping("/{id}")
	public Work getOuvrage(@PathVariable("id") Integer id) {
		return gestionOuvrageService.findById(id);
	}
	
	@GetMapping("/{filter}")
	public List<Work> getOuvrage(@PathVariable("filter") String filter){
		return gestionOuvrageService.getWork(filter);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteWork(@PathVariable("id") Integer id) {
		gestionOuvrageService.delete(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addOuvrages(@Valid @RequestBody WorkDTO request) {
		Work ouvrage = new Work();
		ouvrage.setCote(request.getCote());
		ouvrage.setTitle(request.getTitle());
		ouvrage.setMainAuthor(request.getMainAuthor());
		ouvrage.setOtherAuthor(request.getOtherAuthor());
		ouvrage.setGenre(request.getGenre());
		ouvrage.setEditor(request.getEditor());
		ouvrage.setPublishedDate(request.getPublishedDate());
		ouvrage.setComment(request.getComment());
		ouvrage.setAvailability(request.getAvailability());
		ouvrage.setTypeWork(request.getTypeWork());
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
