package com.anz.wholesale.account.controller;

import com.anz.wholesale.account.constant.AccountEnquiryConstants;
import com.anz.wholesale.account.jsonbean.AccountDetailsRequest;
import com.anz.wholesale.account.jsonbean.AccountResponse;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import com.anz.wholesale.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 */
@Slf4j
@RestController
@RequestMapping("/v1/accountEnquiry")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts", produces = "application/json")
    public ResponseEntity<List<AccountResponse>> getAccounts(
            @Valid @RequestBody AccountDetailsRequest accountRequest) throws Exception {

        List<AccountResponse> accounts = accountService.getAccounts(accountRequest.getUserId());

        if (accounts == null || accounts.size() == 0) {
            throw new EntityNotFoundException(AccountEnquiryConstants.ERR_MSG_ACCOUNTS_NOT_FOUND_FOR_USER);
        }
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping(value = "/{accountNumber}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactions(
            @PathVariable @NotNull String accountNumber) {

        List<TransactionResponse> transactions = accountService.getTransactions(accountNumber);

        if (transactions == null || transactions.size() == 0) {
            throw new EntityNotFoundException(AccountEnquiryConstants.ERR_MSG_TRANSACTIONS_NOT_FOUND_FOR_ACCOUNT);
        }

        return ResponseEntity.ok().body(transactions);
    }
}
