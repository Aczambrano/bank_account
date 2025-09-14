package com.neoris.bankaccount.infrastructure.input.mapper;


import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.infrastructure.input.dto.AccountRequest;
import com.neoris.bankaccount.infrastructure.input.dto.AccountResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountInputMapper {

    AccountResponse toAccountResponse(Account account);

    Account toAccount(AccountRequest accountRequestDTO);
}