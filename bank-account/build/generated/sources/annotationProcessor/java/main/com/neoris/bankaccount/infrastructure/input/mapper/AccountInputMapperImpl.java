package com.neoris.bankaccount.infrastructure.input.mapper;

import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.infrastructure.input.dto.AccountRequest;
import com.neoris.bankaccount.infrastructure.input.dto.AccountResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T13:19:44-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class AccountInputMapperImpl implements AccountInputMapper {

    @Override
    public AccountResponse toAccountResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        Integer accountId = null;
        String accountNumber = null;
        String accountType = null;
        BigDecimal initialBalance = null;
        Boolean status = null;
        Integer customerId = null;

        accountId = account.getAccountId();
        accountNumber = account.getAccountNumber();
        accountType = account.getAccountType();
        initialBalance = account.getInitialBalance();
        status = account.getStatus();
        customerId = account.getCustomerId();

        AccountResponse accountResponse = new AccountResponse( accountId, accountNumber, accountType, initialBalance, status, customerId );

        return accountResponse;
    }

    @Override
    public Account toAccount(AccountRequest accountRequestDTO) {
        if ( accountRequestDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setAccountId( accountRequestDTO.accountId() );
        account.setAccountNumber( accountRequestDTO.accountNumber() );
        account.setAccountType( accountRequestDTO.accountType() );
        account.setInitialBalance( accountRequestDTO.initialBalance() );
        account.setStatus( accountRequestDTO.status() );
        account.setCustomerId( accountRequestDTO.customerId() );

        return account;
    }
}
