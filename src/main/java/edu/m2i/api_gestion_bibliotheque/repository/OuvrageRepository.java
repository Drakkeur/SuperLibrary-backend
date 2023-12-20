package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer>{
	
		@Query("SELECT o FROM Ouvrage o WHERE (o.title LIKE ('%?1%')) OR (o.main_author LIKE ('%?1%')) OR (o.other_author LIKE ('%?1%'))")
		List<Ouvrage> getOuvrage(String filter);
}
