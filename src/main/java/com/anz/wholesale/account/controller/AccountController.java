package com.anz.wholesale.account.controller;

import com.anz.wholesale.account.jsonbean.AccountResponse;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import com.anz.wholesale.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<AccountResponse>> getAccounts(
            @PathVariable @NotNull String userId) {
        log.info("AccountController:Start.");

        List<AccountResponse> accounts = accountService.getAccounts(userId);

        if (accounts == null || accounts.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        log.info("AccountController:End.");
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping(value = "/{accountNumber}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransctions(
            @PathVariable @NotNull String accountNumber) {

        List<TransactionResponse> transactions = accountService.getTransactions(accountNumber);

        if (transactions == null || transactions.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(transactions);
    }

    @GetMapping(value = "/test")
    public void test(){
        log.info("Test");
    }
}
