package com.neoris.bankaccount.infrastructure.input.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovementRequest(
        @NotNull(message = "Account ID cannot be null")
        Integer accountId,

        Integer movementId,

        @NotBlank(message = "Movement type cannot be null")
        @Pattern(regexp = "Deposit|Withdrawal", message = "Type movement must be Deposit or Withdrawal")
        String movementType,

        @NotNull(message = "Value cannot be null")
        @DecimalMin(value = "0.0", inclusive = true, message = "Value must be positive")
        BigDecimal value,

        BigDecimal balance,

        LocalDateTime date
) {}
