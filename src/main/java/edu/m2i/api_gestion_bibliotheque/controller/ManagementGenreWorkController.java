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

import edu.m2i.api_gestion_bibliotheque.dto.GenreWorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.GenreWork;
import edu.m2i.api_gestion_bibliotheque.service.ManagementGenreWorkService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/genre-work")
public class ManagementGenreWorkController {

	@Autowired
	ManagementGenreWorkService managementGenreWorkService;

	// Récupérer la liste complète des genres d'ouvrage
	@GetMapping("/all")
	public List<GenreWork> getAllGenreWork() {
		return managementGenreWorkService.findAll();
	}

	@GetMapping("/{id}")
	public GenreWork getGenreWork(@PathVariable("id") Integer id) {
		return managementGenreWorkService.findById(id);
	}

	// Ajouter un nouveau genre d'Work
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addGenreWork(@Valid @RequestBody GenreWorkDTO request) {
		GenreWork genreWork = new GenreWork();
		genreWork.setName(request.getName());
		genreWork.setCount(0);
		managementGenreWorkService.save(genreWork);
	}

	// Supprimer un genre d'Work
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteGenreWork(@PathVariable("id") Integer id) {
		managementGenreWorkService.delete(id);
	}

	// Modifier un genre d'Work déjà présent dans la DB
	@PutMapping("/update/{id}")
	public void updateGenreWork(@PathVariable("id") Integer id, @RequestBody GenreWorkDTO genreWorkDTO) {
		GenreWork genreWork = managementGenreWorkService.findById(id);
		genreWork.setName(genreWorkDTO.getName());
		managementGenreWorkService.save(genreWork);
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
