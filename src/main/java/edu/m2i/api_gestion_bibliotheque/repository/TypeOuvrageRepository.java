package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.TypeOuvrage;

@Repository
public interface TypeOuvrageRepository extends JpaRepository<TypeOuvrage, Integer> {
	List<TypeOuvrage> findByNameContaining(String filter);
}
