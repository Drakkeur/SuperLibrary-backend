package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.WorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Work;

public interface ManagementWorkService {

	public List<Work> findAll();

	public List<Work> getWorkByTitle(String filter);
	
	public List<Work> getWorkByAuthor(String filter);

	public Work findById(Integer id);

	public WorkDTO findByIdDTO(Integer id);

	public WorkDTO save(Work work);

	public void delete(Integer id);

	public void statusWork(Integer id);

}
