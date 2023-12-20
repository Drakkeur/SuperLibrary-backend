package edu.m2i.api_gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.m2i.api_gestion_bibliotheque.entity.TypeOuvrage;

public interface TypeOuvrageRepository extends JpaRepository <TypeOuvrage, Integer>{

}
