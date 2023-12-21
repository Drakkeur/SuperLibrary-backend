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
import edu.m2i.api_gestion_bibliotheque.entity.TypeWork;
import edu.m2i.api_gestion_bibliotheque.service.ManagementTypeWorkService;
import edu.m2i.api_gestion_bibliotheque.service.ManagementWorkService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/Works")
public class ManagementWorkController {

	@Autowired
	ManagementWorkService managementWorkService;
	@Autowired
	ManagementTypeWorkService managementTypeWorkService;

	@GetMapping("/all")
	public List<Work> getAllWorks() {
		return managementWorkService.findAll();
	}

	@GetMapping("/id/{id}")
	public WorkDTO getOuvrage(@PathVariable("id") Integer id) {
		return managementWorkService.findByIdDTO(id);
	}

	@GetMapping("/filter/title={filter}")
	public List<Work> getWorkByTitle(@PathVariable("filter") String filter) {
		return managementWorkService.getWorkByTitle(filter);
	}

	@GetMapping("/filter/author={filter}")
	public List<Work> getWorkByAuthor(@PathVariable("filter") String filter) {
		return managementWorkService.getWorkByAuthor(filter);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteWork(@PathVariable("id") Integer id) {
		Work Work = managementWorkService.findById(id);
		TypeWork typeWork = Work.getTypeWork();
		typeWork.setCount(typeWork.getCount() - 1);
		managementTypeWorkService.save(typeWork);
		managementWorkService.delete(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public void addWorks(@Valid @RequestBody WorkDTO request) {
		Work work = new Work();
		TypeWork typeWork = managementTypeWorkService.findById(request.getIdTypeWork());
		work.setCote(request.getCote());
		work.setTitle(request.getTitle());
		work.setMainAuthor(request.getMainAuthor());
		work.setOtherAuthor(request.getOtherAuthor());
		work.setGenre(request.getGenre());
		work.setEditor(request.getEditor());
		work.setPublishedDate(request.getPublishedDate());
		work.setComment(request.getComment());
		work.setAvailability(request.getAvailability());
		work.setTypeWork(typeWork);
		work.setTypeWork(managementTypeWorkService.findById(request.getIdTypeWork()));
		work.setTypeWork(managementTypeWorkService.findById(request.getIdTypeWork()));
		managementWorkService.save(work);
		typeWork.setCount(typeWork.getCount()+1);
		managementTypeWorkService.save(typeWork);
	}

	@PutMapping("change-status/{id}")
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
		work.setTypeWork(managementTypeWorkService.findById(request.getIdTypeWork()));
		work.setTypeWork(managementTypeWorkService.findById(request.getIdTypeWork()));
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
