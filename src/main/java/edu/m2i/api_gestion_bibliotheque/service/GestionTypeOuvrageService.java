package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.TypeOuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.TypeOuvrage;

public interface GestionTypeOuvrageService {

	List<TypeOuvrage> findAll();
	
	public TypeOuvrage findById(Integer id);
	
	public List<TypeOuvrage> findByName(String name);

	TypeOuvrageDTO save(TypeOuvrage typeOuvrage);

	void delete(Integer id);

	TypeOuvrage getById(Integer id);

}
