package edu.m2i.api_gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.TypeWork;


@Repository
public interface TypeWorkRepository extends JpaRepository<TypeWork, Integer> {

}
