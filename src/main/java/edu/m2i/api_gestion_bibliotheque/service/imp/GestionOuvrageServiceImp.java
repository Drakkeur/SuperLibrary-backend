package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.entity.TypeOuvrage;
import edu.m2i.api_gestion_bibliotheque.repository.OuvrageRepository;
import edu.m2i.api_gestion_bibliotheque.service.GestionOuvrageService;

@Service
public class GestionOuvrageServiceImp implements GestionOuvrageService {

	@Autowired
	OuvrageRepository ouvrageRepository;

	@Override
	public List<Ouvrage> findAll() {
		return ouvrageRepository.findAll();
	}

	@Override
	public Ouvrage findById(Integer id) {
		return ouvrageRepository.getReferenceById(id);
	}

	@Override
	public List<Ouvrage> getOuvrage(String filter) {
		return ouvrageRepository.findByTitleOrMainAuthorOrOtherAuthorContaining(filter, filter, filter);
	}

	@Override
	public OuvrageDTO save(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
		TypeOuvrage typeOuvrage = ouvrage.getTypeOuvrage();
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
		ouvrageDTO.setIdTypeOuvrage(typeOuvrage.getId());
		return ouvrageDTO;
	}

	@Override
	public void delete(Integer id) {
		ouvrageRepository.deleteById(id);
	}

	public void statusOuvrage(Integer id) {
		Ouvrage ouvrage = ouvrageRepository.getReferenceById(id);
		ouvrageRepository.deleteById(id);
		if (ouvrage.getAvailability() == true) {
			ouvrage.setAvailability(false);
		} else {
			ouvrage.setAvailability(true);
		}
		ouvrageRepository.save(ouvrage);
	}

}
