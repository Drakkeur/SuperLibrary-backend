package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.WorkDTO;
import edu.m2i.api_gestion_bibliotheque.entity.GenreWork;
import edu.m2i.api_gestion_bibliotheque.entity.TypeWork;
import edu.m2i.api_gestion_bibliotheque.entity.Work;
import edu.m2i.api_gestion_bibliotheque.repository.WorkRepository;
import edu.m2i.api_gestion_bibliotheque.service.ManagementWorkService;

@Service
public class ManagementWorkServiceImp implements ManagementWorkService {

	@Autowired
	WorkRepository workRepository;

	@Override
	public List<Work> findAll() {
		return workRepository.findAll();
	}

	@Override
	public WorkDTO findByIdDTO(Integer id) {
		Work work = workRepository.getReferenceById(id);
		TypeWork typeWork = work.getTypeWork();
		GenreWork genreWork = work.getGenre();
		WorkDTO workDTO = new WorkDTO();
		workDTO.setTitle(work.getTitle());
		workDTO.setMainAuthor(work.getMainAuthor());
		workDTO.setOtherAuthor(work.getOtherAuthor());
		workDTO.setGenreWork(genreWork.getId());
		workDTO.setEditor(work.getEditor());
		workDTO.setPublishedDate(work.getPublishedDate());
		workDTO.setComment(work.getComment());
		workDTO.setAvailability(work.getAvailability());
		workDTO.setIdTypeWork(typeWork.getId());
		return workDTO;
	}

	@Override
	public Work findById(Integer id) {
		Work work = workRepository.getReferenceById(id);
		return work;
	}

	@Override
	public List<Work> getWorkByTitle(String filter) {
		return workRepository.findByTitleContaining(filter);
	}
	
	@Override
	public List<Work> getWorkByAuthor(String filter) {
		return workRepository.findByMainAuthorContaining(filter);
	}

	@Override
	public WorkDTO save(Work work) {
		workRepository.save(work);
		TypeWork typeWork = work.getTypeWork();
		GenreWork genreWork = work.getGenre();
		WorkDTO workDTO = new WorkDTO();
		workDTO.setTitle(work.getTitle());
		workDTO.setMainAuthor(work.getMainAuthor());
		workDTO.setOtherAuthor(work.getOtherAuthor());
		workDTO.setGenreWork(genreWork.getId());
		workDTO.setEditor(work.getEditor());
		workDTO.setPublishedDate(work.getPublishedDate());
		workDTO.setComment(work.getComment());
		workDTO.setAvailability(work.getAvailability());
		workDTO.setIdTypeWork(typeWork.getId());
		return workDTO;
	}

	@Override
	public void delete(Integer id) {
		workRepository.deleteById(id);
	}


	@Override
	public void statusWork(Integer id) {
		Work work = workRepository.getReferenceById(id);
		if (work.getAvailability() == true) {
			work.setAvailability(false);
		} else {
			work.setAvailability(true);
		}
		workRepository.save(work);
	}

}
