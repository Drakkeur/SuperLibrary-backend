package edu.m2i.api_gestion_bibliotheque.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "TypeOuvrage")
public class TypeOuvrage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Integer id;
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "typeOuvrage", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Ouvrage> ouvrages;

	public TypeOuvrage() {
		super();
	}

	public TypeOuvrage(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}

	public void addOuvrage(Ouvrage ouvrage) {
		if (this.ouvrages == null) {
			this.ouvrages = new ArrayList<Ouvrage>();
		}
		ouvrage.setTypeOuvrage(this);
		this.ouvrages.add(ouvrage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeOuvrage other = (TypeOuvrage) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "TypeOuvrage [id=" + id + ", name=" + name + "]";
	}

}
