package com.neoris.bankclient.infrastructure.input.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record CustomerRequest(
        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Gender cannot be blank")
        String gender,

        @Min(value = 0, message = "Age must be a positive number")
        Integer age,

        @NotBlank(message = "Identification cannot be blank")
        @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Identification must be alphanumeric")
        String identification,

        String address,

        @NotBlank(message = "Phone cannot be blank")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone must be a valid phone number")
        String phone,

        @NotNull(message = "Customer ID cannot be null")
        Integer customerId,

        @NotBlank(message = "Password cannot be blank")
        String password,

        @NotNull(message = "Status cannot be null")
        Boolean status
) {}

