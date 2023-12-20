package edu.m2i.api_gestion_bibliotheque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.m2i.api_gestion_bibliotheque.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	// Récupérer les emprunts d'un utilisateur
	@Query("SELECT l FROM Loan l WHERE l.user=?1")
	List<Loan> getUserById(Integer idUser);

	// Récupérer les emprunts d'un ouvrage
	@Query("SELECT l FROM Loan l WHERE l.ouvrage=?1")
	List<Loan> getOuvrageById(Integer idOuvrage);

	// Récupérer les emprunts par status
	@Query("SELECT l FROM Loan l WHERE l.status=?1")
	List<Loan> getByStatus(String status);

}
