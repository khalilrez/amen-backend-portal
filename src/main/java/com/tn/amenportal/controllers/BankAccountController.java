package com.tn.amenportal.controllers;

import com.tn.amenportal.dto.BankAccountDTO;
import com.tn.amenportal.models.BankAccount;
import com.tn.amenportal.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank-account")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService service;

    @PostMapping("/create")
    public ResponseEntity<BankAccount> createBankAccount(
            @RequestBody BankAccountDTO request
            ){
        return service.createBankAccount(request);
    }
}
