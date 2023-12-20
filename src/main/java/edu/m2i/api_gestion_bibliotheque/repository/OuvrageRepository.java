package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer>{
	
		@Query("SELECT ouvrage FROM Ouvrage l WHERE ouvrage.title LIKE '%?1%' OR ouvrage.mainauthor LIKE '%?1%' OR ouvrage.otherauthor LIKE '%?1%'")
		List<Ouvrage> getOuvrage(String filter);
}
