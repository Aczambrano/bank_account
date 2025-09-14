package com.neoris.bankclient.infrastructure.input.dto;

public record CustomerResponse(
        Integer customerId,
        String name,
        String gender,
        Integer age,
        String identification,
        String address,
        String phone,
        Boolean status,
        String password
) {}

