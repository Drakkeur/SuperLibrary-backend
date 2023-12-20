package edu.m2i.api_gestion_bibliotheque.dto;

import jakarta.validation.constraints.NotNull;

public class TypeOuvrageDTO {
	@NotNull
	private Integer id;
	@NotNull(message = "Type d'ouvrage est obligatoire")
	private String name;
	
	public TypeOuvrageDTO() {
	}

	public TypeOuvrageDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
