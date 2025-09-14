package com.neoris.bankaccount.application.dto;

import java.math.BigDecimal;
import java.util.List;

public record AccountReport(
        String accountNumber,
        BigDecimal balance,
        List<MovementReport> movements
) {}
