package edu.m2i.api_gestion_bibliotheque.dto;

import java.time.LocalDate;

import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.entity.User;
import jakarta.validation.constraints.NotNull;

public class LoanDTO {

	private LocalDate dateStart;

	private LocalDate theoreticalDateEnd;

	private LocalDate realDateEnd;

	private Integer status;

	@NotNull(message = "ID Ouvrage obligatoire")
	private Ouvrage ouvrage;

	@NotNull(message = "ID Abonné obligatoire")
	private User user;

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

}
