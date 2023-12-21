package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;

public interface GestionOuvrageService {

	public List<Ouvrage> findAll();

	public List<Ouvrage> getOuvrageByTitle(String filter);
	
	public List<Ouvrage> getOuvrageByAuthor(String filter);

	public Ouvrage findById(Integer id);

	public OuvrageDTO findByIdDTO(Integer id);

	public OuvrageDTO save(Ouvrage ouvrage);

	public void delete(Integer id);

	public void statusOuvrage(Integer id);

}
