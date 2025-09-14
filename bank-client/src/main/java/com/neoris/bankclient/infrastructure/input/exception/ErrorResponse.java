package com.neoris.bankclient.infrastructure.input.exception;

public record ErrorResponse(
        int status,
        String error,
        String message
) {}
