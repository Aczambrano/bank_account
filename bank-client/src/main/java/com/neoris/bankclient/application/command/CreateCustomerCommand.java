package com.neoris.bankclient.application.command;

public record CreateCustomerCommand(
        String name,
        String gender,
        Integer age,
        String identification,
        String address,
        String phone,
        String password,
        Boolean status
) {}
