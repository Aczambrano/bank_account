package com.neoris.bankaccount.infrastructure.input.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovementResponse(
        Integer movementId,
        Integer accountId,
        LocalDateTime date,
        String movementType,
        BigDecimal value,
        BigDecimal balance
) {}
