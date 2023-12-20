package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.m2i.api_gestion_bibliotheque.DTO.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.repository.OuvrageRepository;

public class GestionOuvrageImp implements GestionOuvrage{
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	@Override
	public List<Ouvrage> getOuvrage(){
		
	}
	
	@Override
	public List<Ouvrage> getOuvrage(Integer id){
		
	}
	
	@Override
	public List<Ouvrage> getOuvrage(String title){
		
	}
	
	@Override
	public void addOuvrage(Ouvrage ouvrage) {
		OuvrageDTO ouvrageDTO = new OuvrageDTO();
		ouvrageRepository.save(ouvrage);
	}
	
	@Override
	public void deleteOuvrage(Integer id) {
		ouvrageRepository.deleteById(id);
	}
}
