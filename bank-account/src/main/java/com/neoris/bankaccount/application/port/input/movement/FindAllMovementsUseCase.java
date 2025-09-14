package com.neoris.bankaccount.application.port.input.movement;


import com.neoris.bankaccount.application.port.output.IMovementrepository;
import com.neoris.bankaccount.domain.model.Movement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllMovementsUseCase {

    private final IMovementrepository movementRepository;

    public List<Movement> execute() {
        return movementRepository.findAll();
    }

}

