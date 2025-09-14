package com.neoris.bankaccount.infrastructure.input.handler;

import com.neoris.bankaccount.application.port.input.account.CreateAccountUseCase;
import com.neoris.bankaccount.application.port.input.account.DeleteAccountUseCase;
import com.neoris.bankaccount.application.port.input.account.FindAllAccountUseCase;
import com.neoris.bankaccount.application.port.input.account.UpdateAccountUseCase;
import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.infrastructure.input.dto.AccountRequest;
import com.neoris.bankaccount.infrastructure.input.dto.AccountResponse;
import com.neoris.bankaccount.infrastructure.input.mapper.AccountInputMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountHandler {

    private final CreateAccountUseCase createAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final FindAllAccountUseCase findAllAccountUseCase;
    private final AccountInputMapper accountInputMapper;


    public List<AccountResponse> getAccounts() {
        return findAllAccountUseCase.execute().stream()
                .map(accountInputMapper::toAccountResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public AccountResponse createAccount(AccountRequest accountRequest) {
        Account account = accountInputMapper.toAccount(accountRequest);
        return accountInputMapper.toAccountResponse(createAccountUseCase.execute(account));
    }

    public AccountResponse updateAccount(AccountRequest accountRequest) {
        Account account = accountInputMapper.toAccount(accountRequest);
        return accountInputMapper.toAccountResponse(updateAccountUseCase.execute(account));
    }

    public void deleteAccount(Integer accountId) {
        deleteAccountUseCase.execute(accountId);
    }
}
