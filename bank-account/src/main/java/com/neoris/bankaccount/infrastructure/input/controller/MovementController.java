package com.neoris.bankaccount.infrastructure.input.controller;

import com.neoris.bankaccount.infrastructure.input.dto.MovementRequest;
import com.neoris.bankaccount.infrastructure.input.dto.MovementResponse;
import com.neoris.bankaccount.infrastructure.input.dto.ReportResponse;
import com.neoris.bankaccount.infrastructure.input.handler.MovementHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/movimientos")
public class MovementController {

    private final MovementHandler movementHandler;


    @GetMapping
    public ResponseEntity<List<MovementResponse>> findAll() {
        return new ResponseEntity<>(movementHandler.getMovements(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovementResponse> create(@Valid @RequestBody MovementRequest movementRequest) {

        MovementResponse movementResponse = movementHandler.createMovement(movementRequest);
        return new ResponseEntity<>(movementResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MovementResponse> update(@RequestBody @Valid MovementRequest movementRequest) {
        MovementResponse movementResponse = movementHandler.updateMovement(movementRequest);
        return new ResponseEntity<>(movementResponse, HttpStatus.OK);
    }

    @GetMapping("/reportes")
    public ResponseEntity<ReportResponse> generateReport(@RequestParam("fecha") String dateRange,
                                                         @RequestParam("cliente") Integer customerId) {
        String[] dates = dateRange.split(",");

        LocalDateTime startDate = LocalDate.parse(dates[0]).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(dates[1]).atTime(23, 59, 59, 999999999);

        ReportResponse response = movementHandler.generateReport(customerId, startDate, endDate);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

