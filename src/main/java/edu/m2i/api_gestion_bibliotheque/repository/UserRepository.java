package edu.m2i.api_gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.m2i.api_gestion_bibliotheque.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	
}
