package com.neoris.bankaccount.application.port.output;

import com.neoris.bankaccount.domain.model.Movement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IMovementrepository {
    List<Movement> findAll();
    Optional<Movement> findById(Integer id);
    Optional<Movement>  findByAccountId(Integer accountId);
    Movement save(Movement movement);
    Movement update(Movement movement);
    Movement delete(Movement movement);
    List<Movement> findByAccount_AccountIdAndDateBetween(Integer accountId, LocalDateTime startDate, LocalDateTime endDate);

}
