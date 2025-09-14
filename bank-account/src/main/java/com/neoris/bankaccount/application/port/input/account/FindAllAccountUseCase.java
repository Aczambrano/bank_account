package com.neoris.bankaccount.application.port.input.account;

import com.neoris.bankaccount.application.port.output.IAccountRepository;
import com.neoris.bankaccount.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllAccountUseCase {

    private final IAccountRepository accountRepository;

    public List<Account> execute() {
        return accountRepository.findAll();
    }

}
