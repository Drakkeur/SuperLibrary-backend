package edu.m2i.api_gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer>{

}
