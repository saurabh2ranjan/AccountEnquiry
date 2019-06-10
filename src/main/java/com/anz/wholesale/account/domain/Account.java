package com.anz.wholesale.account.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String accountNumber;
    private String accountName;
    //@Enumerated(EnumType.STRING)
    private String accountType;
    private Date balanceDate;
    private String currency;
    private BigDecimal openingAvailableBalance;
}
