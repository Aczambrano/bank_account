package com.neoris.bankaccount.application.port.input.account;

import com.neoris.bankaccount.application.exception.ConflictException;
import com.neoris.bankaccount.application.port.output.IAccountRepository;
import com.neoris.bankaccount.application.port.output.IRabbitMessage;
import com.neoris.bankaccount.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateAccountUseCase {

    private final IAccountRepository accountRepository;
    private final IRabbitMessage rabbitMessage;


    public Account execute(Account account) {

        accountRepository.findByAccountNumber(account.getAccountNumber())
                .ifPresent(
                        account1 -> {
                            throw new ConflictException("Account already exists");
                        }
                );
        Optional.ofNullable(rabbitMessage.sendMessage(account.getCustomerId()))
                .filter(Integer.class::isInstance)
                .map(Integer.class::cast)
                .orElseThrow(() -> new NoSuchElementException("Customer id not found"));

        return accountRepository.save(account);
    }

}

