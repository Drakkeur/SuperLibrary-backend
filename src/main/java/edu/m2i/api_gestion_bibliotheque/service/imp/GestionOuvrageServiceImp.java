package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.m2i.api_gestion_bibliotheque.dto.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.repository.OuvrageRepository;
import edu.m2i.api_gestion_bibliotheque.service.GestionOuvrageService;

public class GestionOuvrageServiceImp implements GestionOuvrageService {

	@Autowired
	OuvrageRepository ouvrageRepository;

	@Override
	public List<Ouvrage> findAll() {
		return ouvrageRepository.findAll();
	}

	@Override
	public OuvrageDTO findById(Integer id) {
		Ouvrage ouvrage = ouvrageRepository.getReferenceById(id);
		OuvrageDTO ouvrageDTO = new OuvrageDTO();
		ouvrageDTO.setCote(ouvrage.getCote());
		ouvrageDTO.setTitle(ouvrage.getTitle());
		ouvrageDTO.setMainAuthor(ouvrage.getMainAuthor());
		ouvrageDTO.setOtherAuthor(ouvrage.getOtherAuthor());
		ouvrageDTO.setGenre(ouvrage.getGenre());
		ouvrageDTO.setEditor(ouvrage.getEditor());
		ouvrageDTO.setPublishedDate(ouvrage.getPublishedDate());
		ouvrageDTO.setComment(ouvrage.getComment());
		ouvrageDTO.setAvailability(ouvrage.getAvailability());
		// ouvrageDTO.setTypeOuvrage(?);
		return ouvrageDTO;
	}

	@Override
	public List<Ouvrage> getOuvrage(String filter) {
		return ouvrageRepository.getOuvrage(filter);
	}

	@Override
	public OuvrageDTO save(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
		OuvrageDTO ouvrageDTO = new OuvrageDTO();
		ouvrageDTO.setCote(ouvrage.getCote());
		ouvrageDTO.setTitle(ouvrage.getTitle());
		ouvrageDTO.setMainAuthor(ouvrage.getMainAuthor());
		ouvrageDTO.setOtherAuthor(ouvrage.getOtherAuthor());
		ouvrageDTO.setGenre(ouvrage.getGenre());
		ouvrageDTO.setEditor(ouvrage.getEditor());
		ouvrageDTO.setPublishedDate(ouvrage.getPublishedDate());
		ouvrageDTO.setComment(ouvrage.getComment());
		ouvrageDTO.setAvailability(ouvrage.getAvailability());
		// ouvrageDTO.setTypeOuvrage(?);
		return ouvrageDTO;
	}

	@Override
	public void delete(Integer id) {
		ouvrageRepository.deleteById(id);
	}

}
