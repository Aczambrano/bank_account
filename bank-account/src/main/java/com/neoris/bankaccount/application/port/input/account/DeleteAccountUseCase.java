package com.neoris.bankaccount.application.port.input.account;

import com.neoris.bankaccount.application.port.output.IAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DeleteAccountUseCase {

    private final IAccountRepository accountRepository;

    public void execute(Integer accountId) {
        accountRepository.findById(accountId)
                .map(account -> {
                    account.setStatus(false);
                    return accountRepository.save(account);
                })
                .orElseThrow(() -> new NoSuchElementException("The account with the given id does not exist."));
    }
}
