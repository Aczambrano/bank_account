package com.neoris.bankclient.infrastructure.input.controller;

import com.neoris.bankclient.infrastructure.input.dto.CustomerRequest;
import com.neoris.bankclient.infrastructure.input.dto.CustomerResponse;
import com.neoris.bankclient.infrastructure.input.handler.CustomerHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class CustomerController {

    private final CustomerHandler customerHandler;

    public CustomerController(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return new ResponseEntity<>(customerHandler.getCustomers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        CustomerResponse response = customerHandler.createCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        CustomerResponse response = customerHandler.updateCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{identification}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer identification) {
        customerHandler.deleteCustomer(identification);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

