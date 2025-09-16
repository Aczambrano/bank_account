package com.neoris.bankaccount.infrastructure.output.mapper;

import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.infrastructure.output.entity.AccountEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-16T12:39:06-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class AccountEntityMapperImpl implements AccountEntityMapper {

    @Override
    public Account entityToAccount(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        Account account = new Account();

        account.setAccountId( accountEntity.getAccountId() );
        account.setAccountNumber( accountEntity.getAccountNumber() );
        account.setAccountType( accountEntity.getAccountType() );
        account.setInitialBalance( accountEntity.getInitialBalance() );
        account.setStatus( accountEntity.getStatus() );
        account.setCustomerId( accountEntity.getCustomerId() );

        account.setMovements( mapMovements(accountEntity) );

        return account;
    }

    @Override
    public AccountEntity accountToEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setAccountId( account.getAccountId() );
        accountEntity.setAccountNumber( account.getAccountNumber() );
        accountEntity.setAccountType( account.getAccountType() );
        accountEntity.setInitialBalance( account.getInitialBalance() );
        accountEntity.setStatus( account.getStatus() );
        accountEntity.setCustomerId( account.getCustomerId() );

        return accountEntity;
    }
}
