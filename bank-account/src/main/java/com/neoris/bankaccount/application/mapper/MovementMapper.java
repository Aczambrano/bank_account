package com.neoris.bankaccount.application.mapper;

import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.output.entity.MovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovementMapper {


    MovementEntity toEntity(Movement movement);

    @Mapping(target = "accountId", source = "account.accountId")
    Movement toDomain(MovementEntity entity);
}