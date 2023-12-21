package edu.m2i.api_gestion_bibliotheque.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.api_gestion_bibliotheque.dto.LoanDTO;
import edu.m2i.api_gestion_bibliotheque.entity.Loan;
import edu.m2i.api_gestion_bibliotheque.repository.LoanRepository;
import edu.m2i.api_gestion_bibliotheque.service.ManagementLoanService;
import edu.m2i.api_gestion_bibliotheque.service.ManagementUserService;
import edu.m2i.api_gestion_bibliotheque.service.ManagementWorkService;

@Service
public class ManagementLoanServiceImp implements ManagementLoanService {
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	ManagementUserService managementUserService;
	@Autowired
	ManagementWorkService managementWorkService;

	@Override
	public LoanDTO save(Loan loan) {
		loan = loanRepository.save(loan);
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setDateStart(loan.getDateStart());
		loanDTO.setTheoreticalDateEnd(loan.getTheoreticalDateEnd());
		loanDTO.setRealDateEnd(loan.getRealDateEnd());
		loanDTO.setStatus(loan.getStatus());
		loanDTO.setIdWork(loan.getWork().getId());
		loanDTO.setIdUser(loan.getUser().getId());
		return loanDTO;
	}

	@Override
	public LoanDTO findById(Integer id) {
		Loan loan = loanRepository.getReferenceById(id);
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setDateStart(loan.getDateStart());
		loanDTO.setTheoreticalDateEnd(loan.getTheoreticalDateEnd());
		loanDTO.setRealDateEnd(loan.getRealDateEnd());
		loanDTO.setStatus(loan.getStatus());
		loanDTO.setIdWork(loan.getWork().getId());
		loanDTO.setIdUser(loan.getUser().getId());
		return loanDTO;
	}

	@Override
	public List<Loan> findAll() {
		return loanRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		loanRepository.deleteById(id);
	}

	@Override
	public List<Loan> getByUser(Integer id) {
		return managementUserService.findById(id).getLoans();
	}

	@Override
	public List<Loan> getByWork(Integer id) {
		return managementWorkService.findById(id).getLoans();
	}

	@Override
	public List<Loan> getByStatus(Integer status) {
		return loanRepository.getByStatus(status);
	}

	@Override
	public void changeStatusLoan(Integer id, String status) {
		Loan loan = loanRepository.getReferenceById(id);
		if (status == "En attente") {
			loan.setStatus(1);
		} else if (status == "En cours") {
			loan.setStatus(2);
		} else if (status == "Terminé") {
			loan.setStatus(0);
		}
	}

}
