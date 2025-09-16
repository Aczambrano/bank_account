package com.neoris.bankaccount.infrastructure.output.mapper;

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
public class MovementEntityMapperImpl implements MovementEntityMapper {

    @Override
    public Movement entityToMovement(MovementEntity movementEntity) {
        if ( movementEntity == null ) {
            return null;
        }

        Movement movement = new Movement();

        movement.setAccountId( movementEntityAccountAccountId( movementEntity ) );
        movement.setMovementId( movementEntity.getMovementId() );
        movement.setDate( movementEntity.getDate() );
        movement.setMovementType( movementEntity.getMovementType() );
        movement.setValue( movementEntity.getValue() );
        movement.setBalance( movementEntity.getBalance() );

        return movement;
    }

    private Integer movementEntityAccountAccountId(MovementEntity movementEntity) {
        AccountEntity account = movementEntity.getAccount();
        if ( account == null ) {
            return null;
        }
        return account.getAccountId();
    }
}
