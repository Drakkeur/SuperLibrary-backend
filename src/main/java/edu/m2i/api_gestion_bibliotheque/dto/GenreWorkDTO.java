package edu.m2i.api_gestion_bibliotheque.dto;

import jakarta.validation.constraints.NotNull;

public class GenreWorkDTO {

	@NotNull(message = "Nom est obligatoire")
	private String name;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
