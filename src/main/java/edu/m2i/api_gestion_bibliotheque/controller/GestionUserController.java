package edu.m2i.api_gestion_bibliotheque.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import edu.m2i.api_gestion_bibliotheque.dto.UserDTO;
import edu.m2i.api_gestion_bibliotheque.entity.User;
import edu.m2i.api_gestion_bibliotheque.service.GestionUserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-superlibrary/user")
public class GestionUserController {

	@Autowired
	GestionUserService gestionUserService;

	// Récupérer la liste de users dans la BDD
	@GetMapping("users")
	public List<User> getUserList() {
		return gestionUserService.findAll();
	}

	// Ajouter un user à la BDD
	@PostMapping("add")
	public void addUser(@Valid @RequestBody UserDTO request) {
		User user = new User();
		user.setAddress(request.getAddress());
		user.setComment(request.getComment());
		user.setCreationDate();
		user.setEmail(request.getEmail());
		user.setFirstname(request.getFirstname());
		user.setLogin(request.getLogin());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setTypeUser(request.getTypeUser());
		gestionUserService.save(user);
		;
	}

	// Supprimer un client à partir de son ID
	@DeleteMapping("delete/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Integer id) {
		gestionUserService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Récupérer un utilisateur par son ID
	@GetMapping("/user/{id}")
	public UserDTO getByIdUser(@PathVariable("id") Integer id) {
		return gestionUserService.findByIdDTO(id);
	}

	// Mise à jour des informations d'un user
	@PutMapping("update/{id}")
	public void updateUser(@PathVariable("id") Integer id, @RequestBody User request) {
		User user = gestionUserService.findById(id);
		user.setAddress(request.getAddress());
		user.setComment(request.getComment());
		user.setCreationDate();
		user.setEmail(request.getEmail());
		user.setFirstname(request.getFirstname());
		user.setLogin(request.getLogin());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setTypeUser(request.getTypeUser());
		gestionUserService.save(user);
		;
	}

	// On peut rajouter différentes manières d'update un client avec des
	// RequestParam dans l'url plus tard

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> erreurs = new HashMap<>();
		e.getBindingResult().getAllErrors()
				.forEach(err -> erreurs.put(((FieldError) err).getField(), err.getDefaultMessage()));
		return erreurs;
	}

}
