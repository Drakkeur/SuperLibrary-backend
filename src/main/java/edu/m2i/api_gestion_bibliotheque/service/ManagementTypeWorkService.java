package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.TypeWorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.TypeWork;

public interface ManagementTypeWorkService {

	List<TypeWork> findAll();
	
	public TypeWork findById(Integer id);
	
	public List<TypeWork> findByName(String name);

	TypeWorkDTO save(TypeWork typeWork);

	void delete(Integer id);
}
