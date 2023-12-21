package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.WorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Work;

public interface ManagementWorkService {

	List<Work> findAll();

	List<Work> getWork(String filter);

	Work findById(Integer id);

	WorkDTO findByIdDTO(Integer id);

	WorkDTO save(Work work);

	void delete(Integer id);

	void statusWork(Integer id);
}
