package edu.m2i.api_gestion_bibliotheque.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "User")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Integer id;
	private Integer typeUser;
	@Column(updatable = false)
	LocalDate creationDate;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String firstname;
	private String address;
	@Column(nullable = false)
	private String email;
	private String phoneNumber;
	private String comment;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JsonIgnore
	private List<Loan> loans;

	public User() {
		super();
	}

	public User(Integer typeUser, String login, String password, String name, String firstname, String address,
			String email, String phoneNumber, String comment) {
		super();
		this.typeUser = typeUser;
		this.creationDate = LocalDate.now();
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

	public Integer getId() {
		return id;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void addLoan(Loan loan) {
		if (this.loans == null) {
			this.loans = new ArrayList<Loan>();
		}
		loan.setUser(this);
		this.loans.add(loan);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, comment, creationDate, email, firstname, id, login, name, password, phoneNumber,
				typeUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(comment, other.comment)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(typeUser, other.typeUser);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", typeUser=" + typeUser + ", creationDate=" + creationDate + ", login=" + login
				+ ", password=" + password + ", name=" + name + ", firstname=" + firstname + ", address=" + address
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", comment=" + comment + "]";
	}

}
