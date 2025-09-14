package com.neoris.bankaccount.application.dto;

import java.util.List;

public record AccountStatementReport(Integer customerId, List<AccountReport> accounts) {
}
