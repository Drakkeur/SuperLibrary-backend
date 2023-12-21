package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.GenreWork;


@Repository
public interface GenreWorkRepository extends JpaRepository<GenreWork, Integer> {
	List<GenreWork> findByNameContaining(String filter);
}
