package com.neoris.bankaccount.infrastructure.input.dto;

import java.math.BigDecimal;

public record AccountResponse(
        Integer accountId,
        String accountNumber,
        String accountType,
        BigDecimal initialBalance,
        Boolean status,
        Integer customerId
) {}
