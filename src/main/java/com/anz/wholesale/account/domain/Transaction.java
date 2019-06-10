package com.anz.wholesale.account.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long accountId;
    private String currency;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitCredit;
    private String transactionNumber;
}
