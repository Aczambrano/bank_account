package com.neoris.bankaccount.infrastructure.output.mapper;

import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.infrastructure.output.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {

    Account entityToAccount(AccountEntity accountEntity);

    AccountEntity accountToEntity(Account account);
}
