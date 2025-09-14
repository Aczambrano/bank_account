package com.neoris.bankaccount.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovementReport(
        Integer movementId,
        Integer accountId,
        LocalDateTime date,
        String movementType,
        BigDecimal value,
        BigDecimal balance
) {}
