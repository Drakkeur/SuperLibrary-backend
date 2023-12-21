package edu.m2i.api_gestion_bibliotheque.service;

import java.util.List;

import edu.m2i.api_gestion_bibliotheque.dto.LoanDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Loan;

public interface ManagementLoanService {
	LoanDTO save(Loan loan);

	LoanDTO findById(Integer id);

	List<Loan> findAll();

	void delete(Integer id);

	List<Loan> getByUser(Integer idUser);

	List<Loan> getByWork(Integer idWork);

	List<Loan> getByStatus(Integer status);

	void changeStatusLoan(Integer id, String status);

}
