package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.m2i.api_gestion_bibliotheque.DTO.LoanDTO;
import edu.m2i.api_gestion_bibliotheque.DTO.OuvrageDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Loan;
import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;
import edu.m2i.api_gestion_bibliotheque.repository.OuvrageRepository;
import edu.m2i.api_gestion_bibliotheque.service.GestionOuvrage;

public class GestionOuvrageImp implements GestionOuvrage{
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	@Override
	public List<Ouvrage> getOuvrage(){
		
	}
	
	@Override
	public OuvrageDTO getOuvrage(Integer id){
		Ouvrage ouvrage = ouvrageRepository.getReferenceById(id);
		OuvrageDTO ouvrageDTO = new OuvrageDTO();
		ouvrageDTO.setDateStart(loan.getDateStart());
		ouvrageDTO.setTheoreticalDateEnd(loan.getTheoreticalDateEnd());
		ouvrageDTO.setRealDateEnd(loan.getRealDateEnd());
		ouvrageDTO.setStatus(loan.getStatus());
		ouvrageDTO.setOuvrage(loan.getOuvrage());
		ouvrageDTO.setUser(loan.getUser());
		return ouvrageDTO;
	}
	
	@Override
	public List<Ouvrage> getOuvrage(String title){
		
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
