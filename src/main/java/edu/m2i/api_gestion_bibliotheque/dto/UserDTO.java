package edu.m2i.api_gestion_bibliotheque.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {

	@NotNull(message = "Type utilisateur obligatoire")
	@Digits(integer = 1, fraction = 0, message = "La valeur doit être 0 pour un bibliothécaire ou 1 pour un abonné")
	private Integer typeUser;

	LocalDate creationDate;

	@NotNull(message = "Login obligatoire")
	@Size(min = 2, max = 30, message = "Nombre de caratères compris entre 2 et 30")
	private String login;

	@NotNull(message = "Mot de passe obligatoire")
	@Size(min = 10, max = 30, message = "Nombre de caratères compris entre 2 et 30")
	private String password;

	@NotNull(message = "Nom obligatoire")
	@Size(min = 2, max = 30, message = "Nombre de caratères compris entre 2 et 30")
	private String name;

	@NotNull(message = "Prénom obligatoire")
	@Size(min = 2, max = 30, message = "Nombre de caratères compris entre 2 et 30")
	private String firstname;

	@Size(min = 5, max = 50, message = "Nombre de caratères compris entre 5 et 50")
	private String address;

	@NotNull(message = "email obligatoire")
	private String email;

	private String phoneNumber;

	private String comment;

	public UserDTO() {

	}

	public UserDTO(Integer typeUser, LocalDate creationDate, String login, String password, String name,
			String firstname, String address, String email, String phoneNumber, String comment) {
		super();
		this.typeUser = typeUser;
		this.creationDate = creationDate;
		this.login = login;
		this.password = password;
		this.name = name;
		this.firstname = firstname;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.comment = comment;
	}

	public Integer getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(Integer typeUser) {
		this.typeUser = typeUser;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
