package com.neoris.bankaccount.infrastructure.input.mapper;

import com.neoris.bankaccount.application.dto.AccountReport;
import com.neoris.bankaccount.application.dto.AccountStatementReport;
import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.input.dto.MovementRequest;
import com.neoris.bankaccount.infrastructure.input.dto.MovementResponse;
import com.neoris.bankaccount.infrastructure.input.dto.ReportResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-14T13:19:44-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class MovementInputMapperImpl implements MovementInputMapper {

    @Override
    public Movement toMovement(MovementRequest movementRequestDTO) {
        if ( movementRequestDTO == null ) {
            return null;
        }

        Movement movement = new Movement();

        movement.setMovementId( movementRequestDTO.movementId() );
        movement.setDate( movementRequestDTO.date() );
        movement.setMovementType( movementRequestDTO.movementType() );
        movement.setValue( movementRequestDTO.value() );
        movement.setBalance( movementRequestDTO.balance() );
        movement.setAccountId( movementRequestDTO.accountId() );

        return movement;
    }

    @Override
    public MovementResponse toMovementResponse(Movement movement) {
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

        MovementResponse movementResponse = new MovementResponse( movementId, accountId, date, movementType, value, balance );

        return movementResponse;
    }

    @Override
    public ReportResponse toReportResponse(AccountStatementReport report) {
        if ( report == null ) {
            return null;
        }

        Integer customerId = null;
        List<AccountReport> accounts = null;

        customerId = report.customerId();
        List<AccountReport> list = report.accounts();
        if ( list != null ) {
            accounts = new ArrayList<AccountReport>( list );
        }

        ReportResponse reportResponse = new ReportResponse( customerId, accounts );

        return reportResponse;
    }
}
