package edu.m2i.api_gestion_bibliotheque.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Loan")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Integer id;
	@Column(nullable = false)
	private LocalDate dateStart;
	@Column(nullable = false)
	private LocalDate theoreticalDateEnd;
	private LocalDate realDateEnd;
	@Column(nullable = false)
	private Integer status;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_ouvrage")
	@JsonIgnoreProperties
	@Column(nullable = false)
	private Ouvrage ouvrage;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	@JsonIgnoreProperties
	@Column(nullable = false)
	private User user;

	public Loan() {
		super();
	}

	public Loan(LocalDate dateStart, LocalDate theoreticalDateEnd, Integer status, Ouvrage ouvrage, User user) {
		super();
		this.dateStart = dateStart;
		this.theoreticalDateEnd = theoreticalDateEnd;
		this.status = status;
		this.ouvrage = ouvrage;
		this.user = user;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getTheoreticalDateEnd() {
		return theoreticalDateEnd;
	}

	public void setTheoreticalDateEnd(LocalDate theoreticalDateEnd) {
		this.theoreticalDateEnd = theoreticalDateEnd;
	}

	public LocalDate getRealDateEnd() {
		return realDateEnd;
	}

	public void setRealDateEnd(LocalDate realDateEnd) {
		this.realDateEnd = realDateEnd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateStart, id, ouvrage, realDateEnd, status, theoreticalDateEnd, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(dateStart, other.dateStart) && Objects.equals(id, other.id)
				&& Objects.equals(ouvrage, other.ouvrage) && Objects.equals(realDateEnd, other.realDateEnd)
				&& Objects.equals(status, other.status) && Objects.equals(theoreticalDateEnd, other.theoreticalDateEnd)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", dateStart=" + dateStart + ", theoreticalDateEnd=" + theoreticalDateEnd
				+ ", realDateEnd=" + realDateEnd + ", status=" + status + ", ouvrage=" + ouvrage + ", user=" + user
				+ "]";
	}

}
