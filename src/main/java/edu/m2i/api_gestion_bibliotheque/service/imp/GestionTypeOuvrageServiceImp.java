package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.TypeOuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.TypeOuvrage;
import edu.m2i.api_gestion_bibliotheque.repository.TypeOuvrageRepository;
import edu.m2i.api_gestion_bibliotheque.service.GestionTypeOuvrageService;

@Service
public class GestionTypeOuvrageServiceImp implements GestionTypeOuvrageService {
	@Autowired
	TypeOuvrageRepository typeOuvrageRepository;

	// Lister tous les types d'ouvrages
	@Override
	public List<TypeOuvrage> findAll() {
		return typeOuvrageRepository.findAll();
	}
	
	public TypeOuvrage findById(Integer id) {
		return typeOuvrageRepository.getReferenceById(id);
	}

	// Sauvegarder un type d'ouvrage
	@Override
	public TypeOuvrageDTO save(TypeOuvrage typeOuvrage) {
		typeOuvrage = typeOuvrageRepository.save(typeOuvrage);
		TypeOuvrageDTO typeOuvrageDTO = new TypeOuvrageDTO();
		typeOuvrageDTO.setName(typeOuvrage.getName());
		return typeOuvrageDTO;
	}

	// Supprimer un type d'ouvrage
	@Override
	public void delete(Integer id) {
		typeOuvrageRepository.deleteById(id);
	}
	
	public List<TypeOuvrage> findByName(String name) {
		return typeOuvrageRepository.findByNameContaining(name);
	}

}
