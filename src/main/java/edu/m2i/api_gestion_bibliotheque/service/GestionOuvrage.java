package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;

public interface GestionOuvrage {
	
	public List<Ouvrage> getOuvrage();
	public void addOuvrage(Ouvrage ouvrage);
	public void deleteOuvrage(Integer id);
}
