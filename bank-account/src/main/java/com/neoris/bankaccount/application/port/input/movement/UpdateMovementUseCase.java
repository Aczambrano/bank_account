package com.neoris.bankaccount.application.port.input.movement;

import com.neoris.bankaccount.application.port.output.IMovementrepository;
import com.neoris.bankaccount.domain.model.Movement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UpdateMovementUseCase {

    private final IMovementrepository movementRepository;

    public Movement execute(Movement movement) {
        return movementRepository.findById(movement.getMovementId())
                .map(existingMovement -> {
                    existingMovement.setMovementType(movement.getMovementType());
                    existingMovement.setValue(movement.getValue());
                    return movementRepository.update(existingMovement);
                })
                .orElseThrow(() -> new NoSuchElementException("The movement with the given id does not exist."));
    }
}
