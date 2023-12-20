package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.DTO.LoanDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Loan;

public interface GestionLoanService {
	LoanDTO save(Loan loan);

	LoanDTO findById(Integer id);

	List<Loan> findAll();

	void delete(Integer id);

	List<Loan> getByUser(Integer idUser);

	List<Loan> getByOuvrage(Integer idOuvrage);

	List<Loan> getByStatus(String status);

	void changeStatusLoan(Integer id, String status);

}
