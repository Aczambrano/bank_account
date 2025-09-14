package com.neoris.bankaccount.application.port.output;

import com.neoris.bankaccount.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository {
    List<Account> findAll();
    Optional<Account> findById(Integer id);
    Optional<Account>  findByAccountNumber(String accountNumber);
    Account save(Account account);
    Account update(Account account);
    List<Account> findByCustomerId(Integer customerId);
}
