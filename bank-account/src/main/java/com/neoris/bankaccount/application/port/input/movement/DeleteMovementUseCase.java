package com.neoris.bankaccount.application.port.input.movement;


import com.neoris.bankaccount.application.port.output.IMovementrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DeleteMovementUseCase {

    private final IMovementrepository movementRepository;

    public void execute(Integer id) {
        movementRepository.findById(id)
                .ifPresentOrElse(
                        movement -> movementRepository.delete(movement),
                        () -> {
                            throw new NoSuchElementException("The movement with the given id does not exist.");
                        }
                );
    }

}

