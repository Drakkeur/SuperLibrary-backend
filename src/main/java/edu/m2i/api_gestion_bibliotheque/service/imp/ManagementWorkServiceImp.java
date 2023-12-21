package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.WorkDTO;
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
	public Work findById(Integer id) {
		return workRepository.getReferenceById(id);
	}

	@Override
	public List<Work> getWork(String filter) {
		return workRepository.findByTitleOrMainAuthorOrOtherAuthorContaining(filter, filter, filter);
	}

	@Override
	public WorkDTO save(Work ouvrage) {
		workRepository.save(ouvrage);
		WorkDTO ouvrageDTO = new WorkDTO();
		ouvrageDTO.setCote(ouvrage.getCote());
		ouvrageDTO.setTitle(ouvrage.getTitle());
		ouvrageDTO.setMainAuthor(ouvrage.getMainAuthor());
		ouvrageDTO.setOtherAuthor(ouvrage.getOtherAuthor());
		ouvrageDTO.setGenre(ouvrage.getGenre());
		ouvrageDTO.setEditor(ouvrage.getEditor());
		ouvrageDTO.setPublishedDate(ouvrage.getPublishedDate());
		ouvrageDTO.setComment(ouvrage.getComment());
		ouvrageDTO.setAvailability(ouvrage.getAvailability());
		ouvrageDTO.setTypeWork(ouvrage.getTypeWork());
		return ouvrageDTO;
	}

	@Override
	public void delete(Integer id) {
		workRepository.deleteById(id);
	}

}
