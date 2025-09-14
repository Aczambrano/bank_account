package com.neoris.bankaccount.application.port.input.movement;

import com.neoris.bankaccount.application.exception.ConflictException;
import com.neoris.bankaccount.application.port.output.IAccountRepository;
import com.neoris.bankaccount.application.port.output.IMovementrepository;
import com.neoris.bankaccount.domain.model.Account;
import com.neoris.bankaccount.domain.model.Movement;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CreateMovementUseCase {

    private final IMovementrepository movementRepository;
    private final IAccountRepository accountRepository;

    @Transactional
    public Movement execute(Movement movement) {

        Account account = accountRepository.findById(movement.getAccountId())
                .orElseThrow(() -> new NoSuchElementException("The account with the given id does not exist."));

        BigDecimal newBalance = account.getInitialBalance().add(movement.getValue());

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new ConflictException("Balance not available");
        }

        movement.setDate(LocalDateTime.now());
        movement.setBalance(newBalance);
        Movement savedMovement = movementRepository.save(movement);

        account.setInitialBalance(newBalance);
        accountRepository.save(account);

        return savedMovement;
    }

}
