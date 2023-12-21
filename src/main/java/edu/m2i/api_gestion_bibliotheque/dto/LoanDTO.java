package edu.m2i.api_gestion_bibliotheque.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class LoanDTO {

	private LocalDate dateStart;

	private LocalDate theoreticalDateEnd;

	private LocalDate realDateEnd;

	private Integer status;

	@NotNull(message = "ID Ouvrage obligatoire")
	private Integer idWork;

	@NotNull(message = "ID Abonné obligatoire")
	private Integer idUser;

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

	public Integer getIdWork() {
		return idWork;
	}

	public void setIdWork(Integer idWork) {
		this.idWork = idWork;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

}
