package com.neoris.bankclient.infrastructure.input.controller;

import com.neoris.bankclient.application.command.CreateCustomerCommand;
import com.neoris.bankclient.application.command.DeleteCustomerCommand;
import com.neoris.bankclient.application.command.UpdateCustomerCommand;
import com.neoris.bankclient.application.command.handler.CreateCustomerHandler;
import com.neoris.bankclient.application.command.handler.DeleteCustomerHandler;
import com.neoris.bankclient.application.command.handler.UpdateCustomerHandler;
import com.neoris.bankclient.application.query.FindAllCustomersQuery;
import com.neoris.bankclient.application.query.handler.FindAllCustomersHandler;
import com.neoris.bankclient.infrastructure.input.dto.CustomerRequest;
import com.neoris.bankclient.infrastructure.input.dto.CustomerResponse;
import com.neoris.bankclient.infrastructure.input.mapper.CustomerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerHandler createHandler;
    private final UpdateCustomerHandler updateHandler;
    private final DeleteCustomerHandler deleteHandler;
    private final FindAllCustomersHandler getCustomersHandler;
    private final CustomerMapper customerMapper;

    // ---------------- Queries ----------------

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<CustomerResponse> response = customerMapper.toResponseList(
                getCustomersHandler.handle(new FindAllCustomersQuery())
        );
        return ResponseEntity.ok(response);
    }

    // ---------------- Commands ----------------

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request) {
        CreateCustomerCommand command = customerMapper.toCreateCommand(request);
        var customer = createHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toResponse(customer));
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@Valid @RequestBody CustomerRequest request) {
        UpdateCustomerCommand command = customerMapper.toUpdateCommand(request);
        var customer = updateHandler.handle(command);
        return ResponseEntity.ok(customerMapper.toResponse(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        deleteHandler.handle(new DeleteCustomerCommand(id));
        return ResponseEntity.ok().build();
    }
}

