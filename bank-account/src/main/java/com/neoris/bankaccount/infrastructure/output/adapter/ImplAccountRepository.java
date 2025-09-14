package com.neoris.bankaccount.infrastructure.output.adapter;


import com.neoris.bankaccount.application.port.output.IAccountRepository;
import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.infrastructure.output.entity.AccountEntity;
import com.neoris.bankaccount.infrastructure.output.mapper.AccountEntityMapper;
import com.neoris.bankaccount.infrastructure.output.repository.IOutputAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ImplAccountRepository implements IAccountRepository {

    private final IOutputAccountRepository accountRepository;
    private final AccountEntityMapper accountEntityMapper;


    @Override
    public List<Account> findAll() {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        return accountEntities.stream()
                .map(accountEntityMapper::entityToAccount)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findById(Integer id) {
        Optional<AccountEntity> accountEntity = accountRepository.findById(id);
        return accountEntity.map(accountEntityMapper::entityToAccount);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        Optional<AccountEntity> accountEntity = accountRepository.findByAccountNumber(accountNumber);
        return accountEntity.map(accountEntityMapper::entityToAccount);
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = accountEntityMapper.accountToEntity(account);
        AccountEntity savedEntity = accountRepository.save(accountEntity);
        return accountEntityMapper.entityToAccount(savedEntity);
    }

    @Override
    public Account update(Account account) {
        Optional<AccountEntity> existingEntity = accountRepository.findById(account.getAccountId());

        if (existingEntity.isPresent()) {
            AccountEntity updatedEntity = existingEntity.get();
            updatedEntity.setAccountNumber(account.getAccountNumber());
            updatedEntity.setAccountType(account.getAccountType());
            updatedEntity.setInitialBalance(account.getInitialBalance());
            updatedEntity.setStatus(account.getStatus());
            updatedEntity.setCustomerId(account.getCustomerId());
            accountRepository.save(updatedEntity);
            return accountEntityMapper.entityToAccount(updatedEntity);
        } else {
            throw new NoSuchElementException("Account not found");
        }
    }

    @Override
    public List<Account> findByCustomerId(Integer customerId) {
        List<AccountEntity> accountEntities = accountRepository.findByCustomerId(customerId);
        return accountEntities.stream()
                .map(accountEntityMapper::entityToAccount)
                .collect(Collectors.toList());
    }
}

