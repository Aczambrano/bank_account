package com.neoris.bankaccount.application.mapper;

import com.neoris.bankaccount.application.dto.MovementReport;
import com.neoris.bankaccount.domain.model.Movement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementReportMapper {

    MovementReport toMovementReport(Movement movement);
}