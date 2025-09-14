package com.neoris.bankaccount.infrastructure.output.mapper;

import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.output.entity.AccountEntity;
import com.neoris.bankaccount.infrastructure.output.entity.MovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface MovementEntityMapper {

    @Mapping(source = "movementEntity.account.accountId", target = "accountId")
    Movement entityToMovement(MovementEntity movementEntity);

    @Mapping(source = "accountId", target = "account")
    default MovementEntity movementToEntity(Movement movement) {
        if (movement == null) {
            return null;
        }
        MovementEntity entity = new MovementEntity();
        entity.setMovementId(movement.getMovementId());
        entity.setDate(movement.getDate());
        entity.setMovementType(movement.getMovementType());
        entity.setValue(movement.getValue());
        entity.setBalance(movement.getBalance());
        entity.setAccount(new AccountEntity(movement.getAccountId()));
        return entity;
    }
}
