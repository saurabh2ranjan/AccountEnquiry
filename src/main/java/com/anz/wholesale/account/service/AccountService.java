package com.anz.wholesale.account.service;

import com.anz.wholesale.account.jsonbean.AccountResponse;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import com.anz.wholesale.account.mapper.AccountMapper;
import com.anz.wholesale.account.mapper.TransactionMapper;
import com.anz.wholesale.account.repository.AccountRepository;
import com.anz.wholesale.account.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    public List<AccountResponse> getAccounts(String userId) {
        return AccountMapper.toAccountResponse(accountRepository.findByUserId(userId));
    }

    public List<TransactionResponse> getTransactions(long accountId) {
        return TransactionMapper.toTransactionResponse(transactionRepository.findByAccountId(accountId));
    }
}
