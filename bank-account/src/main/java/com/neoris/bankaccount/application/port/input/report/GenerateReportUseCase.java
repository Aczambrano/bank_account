package com.neoris.bankaccount.application.port.input.report;

import com.neoris.bankaccount.application.dto.AccountReport;
import com.neoris.bankaccount.application.dto.AccountStatementReport;
import com.neoris.bankaccount.application.dto.MovementReport;
import com.neoris.bankaccount.application.mapper.MovementReportMapper;
import com.neoris.bankaccount.application.port.output.IAccountRepository;
import com.neoris.bankaccount.application.port.output.IMovementrepository;
import com.neoris.bankaccount.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenerateReportUseCase {

    private final IAccountRepository accountRepository;
    private final IMovementrepository movementRepository;
    private final MovementReportMapper movementReportMapper;


    public AccountStatementReport execute(Integer customerId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);

        List<AccountReport> accountReports = accounts.stream().map(account -> {
            List<MovementReport> movements = movementRepository.findByAccount_AccountIdAndDateBetween(
                            account.getAccountId(), startDate, endDate
                    ).stream().map(movementReportMapper::toMovementReport)
                    .toList();

            return new AccountReport(account.getAccountNumber(), account.getInitialBalance(), movements);
        }).collect(Collectors.toList());

        return new AccountStatementReport(customerId, accountReports);
    }

}

