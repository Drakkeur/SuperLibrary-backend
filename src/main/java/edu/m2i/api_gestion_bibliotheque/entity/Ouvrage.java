package edu.m2i.api_gestion_bibliotheque.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import jakarta.persistence.OneToMany;

@Entity(name = "Ouvrage")
public class Ouvrage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Integer id;
	private String cote;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String mainAuthor;
	private String otherAuthor;
	@Column(nullable = false)
	private String genre;
	@Column(nullable = false)
	private String editor;
	private LocalDate publishedDate;
	private String comment;
	private Boolean availability;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_typeOuvrage", nullable = false)
	@JsonIgnoreProperties
	private TypeOuvrage typeOuvrage;

	@OneToMany(mappedBy = "ouvrage", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Loan> loans;

	public Ouvrage() {
		super();
	}

	public Ouvrage(String cote, String title, String mainAuthor, String otherAuthor, String genre, String editor,
			LocalDate publishedDate, String comment, Boolean availability, TypeOuvrage typeOuvrage) {
		super();
		this.cote = cote;
		this.title = title;
		this.mainAuthor = mainAuthor;
		this.otherAuthor = otherAuthor;
		this.genre = genre;
		this.editor = editor;
		this.publishedDate = publishedDate;
		this.comment = comment;
		this.availability = availability;
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

	public TypeOuvrage getTypeOuvrage() {
		return typeOuvrage;
	}

	public void setTypeOuvrage(TypeOuvrage typeOuvrage) {
		this.typeOuvrage = typeOuvrage;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void addLoan(Loan loan) {
		if (this.loans == null) {
			this.loans = new ArrayList<Loan>();
		}
		loan.setOuvrage(this);
		this.loans.add(loan);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availability, comment, cote, editor, genre, id, mainAuthor, otherAuthor, publishedDate,
				title, typeOuvrage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		return Objects.equals(availability, other.availability) && Objects.equals(comment, other.comment)
				&& Objects.equals(cote, other.cote) && Objects.equals(editor, other.editor)
				&& Objects.equals(genre, other.genre) && Objects.equals(id, other.id)
				&& Objects.equals(mainAuthor, other.mainAuthor) && Objects.equals(otherAuthor, other.otherAuthor)
				&& Objects.equals(publishedDate, other.publishedDate) && Objects.equals(title, other.title)
				&& Objects.equals(typeOuvrage, other.typeOuvrage);
	}

	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", cote=" + cote + ", title=" + title + ", mainAuthor=" + mainAuthor
				+ ", otherAuthor=" + otherAuthor + ", genre=" + genre + ", editor=" + editor + ", publishedDate="
				+ publishedDate + ", comment=" + comment + ", availability=" + availability + ", typeOuvrage="
				+ typeOuvrage + "]";
	}

}
