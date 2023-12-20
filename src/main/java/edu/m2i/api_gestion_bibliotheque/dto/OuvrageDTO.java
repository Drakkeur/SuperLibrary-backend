package edu.m2i.api_gestion_bibliotheque.dto;

import java.time.LocalDate;

import edu.m2i.api_gestion_bibliotheque.entity.TypeOuvrage;
import jakarta.validation.constraints.NotNull;

public class OuvrageDTO {

	private String cote;

	@NotNull(message = "Titre obligatoire")
	private String title;

	@NotNull(message = "Auteur principale obligatoire")
	private String mainAuthor;

	private String otherAuthor;

	@NotNull(message = "Genre obligatoire")
	private String genre;

	@NotNull(message = "Editeur obligatoire")
	private String editor;

	private LocalDate publishedDate;

	private String comment;

	private Boolean availability;
	
	private TypeOuvrage typeOuvrage;

	public TypeOuvrage getTypeOuvrage() {
		return typeOuvrage;
	}

	public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
		this.typeOuvrage = typeOuvrage;
	}

	public String getCote() {
		return cote;
	}

	public void setCote(String cote) {
		this.cote = cote;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainAuthor() {
		return mainAuthor;
	}

	public void setMainAuthor(String mainAuthor) {
		this.mainAuthor = mainAuthor;
	}

	public String getOtherAuthor() {
		return otherAuthor;
	}

	public void setOtherAuthor(String otherAuthor) {
		this.otherAuthor = otherAuthor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
}
