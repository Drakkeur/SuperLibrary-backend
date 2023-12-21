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

	// Lister tous les types d'works
	@Override
	public List<TypeWork> findAll() {
		return typeWorkRepository.findAll();
	}

	// Sauvegarder un type d'work
	@Override
	public TypeWorkDTO save(TypeWork typeWork) {
		typeWork = typeWorkRepository.save(typeWork);
		TypeWorkDTO typeWorkDTO = new TypeWorkDTO();
		typeWorkDTO.setName(typeWork.getName());
		return typeWorkDTO;
	}

	// Supprimer un type d'work
	@Override
	public void delete(Integer id) {
		typeWorkRepository.deleteById(id);
	}
	
	public List<TypeWork> findByName(String name) {
		return typeWorkRepository.findByNameContaining(name);
	}

	// Récupérer un type d'work à partir de l'ID
	@Override
	public TypeWork findById(Integer id) {
		return typeWorkRepository.getReferenceById(id);
	}

}
