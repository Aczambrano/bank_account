package com.neoris.bankaccount.infrastructure.input.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record AccountRequest(
        Integer accountId,

        @NotBlank(message = "Account number cannot be blank")
        String accountNumber,

        @NotBlank(message = "Account type cannot be blank")
        String accountType,

        @NotNull(message = "Initial balance cannot be null")
        @DecimalMin(value = "0.0", inclusive = true, message = "Initial balance must be a positive number")
        BigDecimal initialBalance,

        @NotNull(message = "Status cannot be null")
        Boolean status,

        @NotNull(message = "Customer ID cannot be null")
        Integer customerId
) {}
