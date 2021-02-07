package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.loans.InstantLoan;
import org.springframework.data.repository.CrudRepository;

public interface InstantLoanRepository extends CrudRepository<InstantLoan, Long> {
}
