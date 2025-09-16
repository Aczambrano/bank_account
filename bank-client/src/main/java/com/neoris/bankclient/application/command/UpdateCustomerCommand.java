package com.neoris.bankclient.application.command;

public record UpdateCustomerCommand(
        Integer customerId,
        String name,
        String gender,
        Integer age,
        String identification,
        String address,
        String phone,
        String password,
        Boolean status
) {}
