package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.GenreWorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.GenreWork;

public interface ManagementGenreWorkService {

	List<GenreWork> findAll();
	
	public GenreWork findById(Integer id);
	
	public List<GenreWork> findByName(String name);

	GenreWorkDTO save(GenreWork genreWork);

	void delete(Integer id);
}
