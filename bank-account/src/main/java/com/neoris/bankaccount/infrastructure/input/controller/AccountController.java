package com.neoris.bankaccount.infrastructure.input.controller;

import com.neoris.bankaccount.infrastructure.input.dto.AccountRequest;
import com.neoris.bankaccount.infrastructure.input.dto.AccountResponse;
import com.neoris.bankaccount.infrastructure.input.handler.AccountHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas")
@AllArgsConstructor
public class AccountController {

    private final AccountHandler accountHandler;

    @GetMapping
    public ResponseEntity<List<AccountResponse>> findAll() {
        return new ResponseEntity<>(accountHandler.getAccounts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Valid AccountRequest accountRequest) {
        AccountResponse response = accountHandler.createAccount(accountRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccountResponse> updateAccount(@RequestBody @Valid AccountRequest accountRequest) {
        AccountResponse response = accountHandler.updateAccount(accountRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer accountId) {
        accountHandler.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

