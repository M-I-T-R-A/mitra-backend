package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
