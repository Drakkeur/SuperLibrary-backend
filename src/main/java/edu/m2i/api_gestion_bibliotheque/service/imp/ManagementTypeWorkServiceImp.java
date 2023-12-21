package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.TypeWorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.TypeWork;
import edu.m2i.api_gestion_bibliotheque.repository.TypeWorkRepository;
import edu.m2i.api_gestion_bibliotheque.service.ManagementTypeWorkService;

@Service
public class ManagementTypeWorkServiceImp implements ManagementTypeWorkService {
	@Autowired
	TypeWorkRepository typeWorkRepository;

	// Lister tous les types d'ouvrages
	@Override
	public List<TypeWork> findAll() {
		return typeWorkRepository.findAll();
	}

	// Sauvegarder un type d'ouvrage
	@Override
	public TypeWorkDTO save(TypeWork typeOuvrage) {
		typeOuvrage = typeWorkRepository.save(typeOuvrage);
		TypeWorkDTO typeOuvrageDTO = new TypeWorkDTO();
		typeOuvrageDTO.setName(typeOuvrage.getName());
		return typeOuvrageDTO;
	}

	// Supprimer un type d'ouvrage
	@Override
	public void delete(Integer id) {
		typeWorkRepository.deleteById(id);
	}

}
