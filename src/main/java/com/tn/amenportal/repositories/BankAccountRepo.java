package com.tn.amenportal.repositories;

import com.tn.amenportal.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepo extends JpaRepository<BankAccount,Long> {
    Optional<BankAccount> findBankAccountByRib(String rib);
}
