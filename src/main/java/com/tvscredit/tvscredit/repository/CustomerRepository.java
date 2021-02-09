package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.person.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Customer findByPhoneNumber(String phoneNumber);
}
