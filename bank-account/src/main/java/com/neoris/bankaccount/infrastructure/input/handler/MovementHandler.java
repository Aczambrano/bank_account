package com.neoris.bankaccount.infrastructure.input.handler;

import com.neoris.bankaccount.application.dto.AccountStatementReport;
import com.neoris.bankaccount.application.port.input.movement.CreateMovementUseCase;
import com.neoris.bankaccount.application.port.input.movement.DeleteMovementUseCase;
import com.neoris.bankaccount.application.port.input.movement.FindAllMovementsUseCase;
import com.neoris.bankaccount.application.port.input.movement.UpdateMovementUseCase;
import com.neoris.bankaccount.application.port.input.report.GenerateReportUseCase;
import com.neoris.bankaccount.domain.model.Movement;
import com.neoris.bankaccount.infrastructure.input.dto.MovementRequest;
import com.neoris.bankaccount.infrastructure.input.dto.MovementResponse;
import com.neoris.bankaccount.infrastructure.input.dto.ReportResponse;
import com.neoris.bankaccount.infrastructure.input.mapper.MovementInputMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MovementHandler {

    private final CreateMovementUseCase createMovementUseCase;
    private final UpdateMovementUseCase updateMovementUseCase;
    private final DeleteMovementUseCase deleteMovementUseCase;
    private final FindAllMovementsUseCase findAllMovementsUseCase;
    private final GenerateReportUseCase generateReportUseCase;
    private final MovementInputMapper movementInputMapper;

    public List<MovementResponse> getMovements() {
        return findAllMovementsUseCase.execute().stream()
                .map(movementInputMapper::toMovementResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public MovementResponse createMovement(MovementRequest movementRequest) {
        Movement movement = movementInputMapper.toMovement(movementRequest);
        return movementInputMapper.toMovementResponse(createMovementUseCase.execute(movement));
    }

    public MovementResponse updateMovement(MovementRequest movementRequest) {
        Movement movement = movementInputMapper.toMovement(movementRequest);
        return movementInputMapper.toMovementResponse(updateMovementUseCase.execute(movement));
    }

    public void deleteMovement(Integer movementId) {
        deleteMovementUseCase.execute(movementId);
    }

    public ReportResponse generateReport(Integer customerId, LocalDateTime startDate, LocalDateTime endDate) {
        AccountStatementReport accountStatementReport = generateReportUseCase.execute(customerId, startDate, endDate);
        return movementInputMapper.toReportResponse(accountStatementReport);
    }


}

