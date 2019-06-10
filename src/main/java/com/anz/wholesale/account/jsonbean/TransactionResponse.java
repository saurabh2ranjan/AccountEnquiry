package com.anz.wholesale.account.jsonbean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionResponse {

    Long id;
    String accountId;
    String accountNumber;
    String accountName;
    String currency;
    BigDecimal debitAmount;
    BigDecimal creditAmount;
    String debitCredit;
    String transactionNumber;
}
