package com.neoris.bankaccount.infrastructure.input.dto;

import com.neoris.bankaccount.application.dto.AccountReport;
import java.util.List;

public record ReportResponse(
        Integer customerId,
        List<AccountReport> accounts
) {}
