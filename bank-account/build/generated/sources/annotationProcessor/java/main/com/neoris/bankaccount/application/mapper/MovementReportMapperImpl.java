package com.neoris.bankaccount.application.mapper;

import com.neoris.bankaccount.application.dto.MovementReport;
import com.neoris.bankaccount.domain.model.Movement;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T14:09:21-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class MovementReportMapperImpl implements MovementReportMapper {

    @Override
    public MovementReport toMovementReport(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        Integer movementId = null;
        Integer accountId = null;
        LocalDateTime date = null;
        String movementType = null;
        BigDecimal value = null;
        BigDecimal balance = null;

        movementId = movement.getMovementId();
        accountId = movement.getAccountId();
        date = movement.getDate();
        movementType = movement.getMovementType();
        value = movement.getValue();
        balance = movement.getBalance();

        MovementReport movementReport = new MovementReport( movementId, accountId, date, movementType, value, balance );

        return movementReport;
    }
}
