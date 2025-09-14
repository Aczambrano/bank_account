package com.neoris.bankaccount.infrastructure.input.exception;

public record ErrorResponse(
        int status,
        String error,
        String message
) {}
