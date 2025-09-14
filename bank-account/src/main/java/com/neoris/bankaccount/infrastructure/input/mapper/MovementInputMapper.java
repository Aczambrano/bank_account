package com.neoris.bankaccount.infrastructure.input.mapper;

import com.neoris.bankaccount.application.dto.AccountStatementReport;
import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.input.dto.MovementRequest;
import com.neoris.bankaccount.infrastructure.input.dto.MovementResponse;
import com.neoris.bankaccount.infrastructure.input.dto.ReportResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementInputMapper {

    Movement toMovement(MovementRequest movementRequestDTO);

    MovementResponse toMovementResponse(Movement movement);

    ReportResponse toReportResponse(AccountStatementReport report);
}
