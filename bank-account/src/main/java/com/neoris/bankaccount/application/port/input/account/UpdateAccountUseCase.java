package com.neoris.bankaccount.application.port.input.account;


import com.neoris.bankaccount.application.port.output.IAccountRepository;
import com.neoris.bankaccount.application.port.output.IRabbitMessage;
import com.neoris.bankaccount.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateAccountUseCase {
    private final IAccountRepository accountRepository;
    private final IRabbitMessage rabbitMessage;

    public Account execute(Account account) {

        Optional.ofNullable(rabbitMessage.sendMessage(account.getCustomerId()))
                .filter(Integer.class::isInstance)
                .map(Integer.class::cast)
                .orElseThrow(() -> new NoSuchElementException("Customer id not found"));

        return accountRepository.findById(account.getAccountId())
                .map(existingAccount -> {
                    existingAccount.setAccountType(account.getAccountType());
                    existingAccount.setInitialBalance(account.getInitialBalance());
                    existingAccount.setStatus(account.getStatus());
                    return accountRepository.update(existingAccount);
                })
                .orElseThrow(() -> new NoSuchElementException("The account with the given id does not exist."));
    }
}

