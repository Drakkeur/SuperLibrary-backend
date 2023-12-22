package edu.m2i.api_gestion_bibliotheque.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GenreWorkDTO {

	@NotNull(message = "Nom est obligatoire")
	@Size(min = 2, max = 30, message = "Nombre de caratères compris entre 2 et 30")
	private String name;
	@NotNull(message = "Un ID est obligatoire")
	@Min(100)
	@Max(999)
	private Integer id;
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
	
	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
