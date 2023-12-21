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

import edu.m2i.api_gestion_bibliotheque.dto.WorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Work;
import edu.m2i.api_gestion_bibliotheque.service.ManagementWorkService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/ouvrages")
public class ManagementWorkController {

	@Autowired
	ManagementWorkService managementWorkService;

	@GetMapping("/all")
	public List<Work> getAllOuvrages() {
		return managementWorkService.findAll();
	}

	@GetMapping("/{id}")
	public Work getOuvrage(@PathVariable("id") Integer id) {
		return managementWorkService.findById(id);
	}
	
	@GetMapping("/{filter}")
	public List<Work> getOuvrage(@PathVariable("filter") String filter){
		return managementWorkService.getWork(filter);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteWork(@PathVariable("id") Integer id) {
		managementWorkService.delete(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addWork(@Valid @RequestBody WorkDTO request) {
		Work work = new Work();
		work.setCote(request.getCote());
		work.setTitle(request.getTitle());
		work.setMainAuthor(request.getMainAuthor());
		work.setOtherAuthor(request.getOtherAuthor());
		work.setGenre(request.getGenre());
		work.setEditor(request.getEditor());
		work.setPublishedDate(request.getPublishedDate());
		work.setComment(request.getComment());
		work.setAvailability(request.getAvailability());
		work.setTypeWork(request.getTypeWork());
		managementWorkService.save(work);
	}
	
	@GetMapping("change-status/{id}")
	public void statusWork(@PathVariable("id") Integer id) {
		managementWorkService.statusWork(id);
	}
	
	@PutMapping("update/{id}")
	public void updateUser(@PathVariable("id") Integer id, @RequestBody WorkDTO request) {
		Work work = managementWorkService.findById(id);
		work.setCote(request.getCote());
		work.setTitle(request.getTitle());
		work.setMainAuthor(request.getMainAuthor());
		work.setOtherAuthor(request.getOtherAuthor());
		work.setGenre(request.getGenre());
		work.setEditor(request.getEditor());
		work.setPublishedDate(request.getPublishedDate());
		work.setComment(request.getComment());
		work.setAvailability(request.getAvailability());
		work.setTypeWork(request.getTypeWork());
		managementWorkService.save(work);
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