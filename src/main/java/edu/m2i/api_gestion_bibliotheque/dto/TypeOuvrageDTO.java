package edu.m2i.api_gestion_bibliotheque.dto;

import jakarta.validation.constraints.NotNull;

public class TypeOuvrageDTO {

	@NotNull(message = "Nom est obligatoire")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
