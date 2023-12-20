package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.m2i.api_gestion_bibliotheque.DTO.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.repository.OuvrageRepository;
import edu.m2i.api_gestion_bibliotheque.service.GestionOuvrage;

public class GestionOuvrageImp implements GestionOuvrage{
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	@Override
	public List<Ouvrage> getOuvrage(){
		return ouvrageRepository.findAll();
	}
	
	@Override
	public OuvrageDTO getOuvrage(Integer id){
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
		return ouvrageDTO;
	}
	
	@Override
	public List<Ouvrage> getOuvrage(String filter){
		return ouvrageRepository.getOuvrage(filter);
	}
	
	@Override
	public void save(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
	}
	
	@Override
	public void deleteOuvrage(Integer id) {
		ouvrageRepository.deleteById(id);
	}
}
