package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;
import org.springframework.data.repository.CrudRepository;

public interface InstantLoanSurrogatesRepository extends CrudRepository<InstantLoanSurrogates, Long> {
    public InstantLoanSurrogates findByCustomer(Customer customer);
}
