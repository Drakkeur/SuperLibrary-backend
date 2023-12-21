package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {

	List<Work> findByTitleOrMainAuthorOrOtherAuthorContaining(String filter1, String filter2, String filter3);

}
