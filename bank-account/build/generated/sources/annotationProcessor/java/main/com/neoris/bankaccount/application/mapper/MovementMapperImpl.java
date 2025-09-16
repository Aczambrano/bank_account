package com.neoris.bankaccount.application.mapper;

import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.output.entity.AccountEntity;
import com.neoris.bankaccount.infrastructure.output.entity.MovementEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-16T12:18:17-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class MovementMapperImpl implements MovementMapper {

    @Override
    public MovementEntity toEntity(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        MovementEntity movementEntity = new MovementEntity();

        movementEntity.setMovementId( movement.getMovementId() );
        movementEntity.setDate( movement.getDate() );
        movementEntity.setMovementType( movement.getMovementType() );
        movementEntity.setValue( movement.getValue() );
        movementEntity.setBalance( movement.getBalance() );

        return movementEntity;
    }

    @Override
    public Movement toDomain(MovementEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Movement movement = new Movement();

        movement.setAccountId( entityAccountAccountId( entity ) );
        movement.setMovementId( entity.getMovementId() );
        movement.setDate( entity.getDate() );
        movement.setMovementType( entity.getMovementType() );
        movement.setValue( entity.getValue() );
        movement.setBalance( entity.getBalance() );

        return movement;
    }

    private Integer entityAccountAccountId(MovementEntity movementEntity) {
        AccountEntity account = movementEntity.getAccount();
        if ( account == null ) {
            return null;
        }
        return account.getAccountId();
    }
}
