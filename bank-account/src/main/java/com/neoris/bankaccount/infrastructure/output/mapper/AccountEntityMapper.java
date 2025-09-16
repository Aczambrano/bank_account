package com.neoris.bankaccount.infrastructure.output.mapper;

import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.output.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {
    @Mapping(target = "movements", expression = "java(mapMovements(accountEntity))")
    Account entityToAccount(AccountEntity accountEntity);

    default List<Movement> mapMovements(AccountEntity accountEntity) {
        if (accountEntity.getMovements() == null) return null;
        return accountEntity.getMovements().stream()
                .map(m -> {
                    Movement movement = new Movement();
                    movement.setMovementId(m.getMovementId());
                    movement.setDate(m.getDate());
                    movement.setMovementType(m.getMovementType());
                    movement.setValue(m.getValue());
                    movement.setBalance(m.getBalance());
                    movement.setAccountId(accountEntity.getAccountId());
                    return movement;
                }).collect(Collectors.toList());
    }

    @Mapping(target = "movements", ignore = true)
    AccountEntity accountToEntity(Account account);
}
