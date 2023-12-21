package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.GenreWorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.GenreWork;
import edu.m2i.api_gestion_bibliotheque.repository.GenreWorkRepository;
import edu.m2i.api_gestion_bibliotheque.service.ManagementGenreWorkService;

@Service
public class ManagementGenreWorkServiceImp implements ManagementGenreWorkService {
	@Autowired
	GenreWorkRepository genreWorkRepository;

	// Lister tous les types d'works
	@Override
	public List<GenreWork> findAll() {
		return genreWorkRepository.findAll();
	}

	// Sauvegarder un type d'work
	@Override
	public GenreWorkDTO save(GenreWork genreWork) {
		genreWork = genreWorkRepository.save(genreWork);
		GenreWorkDTO genreWorkDTO = new GenreWorkDTO();
		genreWorkDTO.setName(genreWork.getName());
		return genreWorkDTO;
	}

	// Supprimer un type d'work
	@Override
	public void delete(Integer id) {
		genreWorkRepository.deleteById(id);
	}
	
	public List<GenreWork> findByName(String name) {
		return genreWorkRepository.findByNameContaining(name);
	}

	// Récupérer un type d'work à partir de l'ID
	@Override
	public GenreWork findById(Integer id) {
		return genreWorkRepository.getReferenceById(id);
	}

}
