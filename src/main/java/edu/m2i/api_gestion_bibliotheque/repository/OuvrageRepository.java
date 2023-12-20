package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.Ouvrage;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer> {

	List<Ouvrage> findByTitleOrMainAuthorOrOtherAuthorContaining(String filter1, String filter2, String filter3);

}
