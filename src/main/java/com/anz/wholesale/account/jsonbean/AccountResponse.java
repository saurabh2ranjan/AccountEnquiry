package com.anz.wholesale.account.jsonbean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class AccountResponse {

    Long id;
    String userId;
    String accountNumber;
    String accountName;
    String accountType;
    Date balanceDate;
    String currency;
    BigDecimal openingAvailableBalance;


}
