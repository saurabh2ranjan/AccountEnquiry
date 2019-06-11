package com.anz.wholesale.account.jsonbean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class TxnDetailsRequest implements Serializable {

    @NotNull(message = "Account number cannot be null.")
    @Pattern(regexp = "^[0-9]*$", message = "account Number must contain numbers or hyphen & must begin and end with number.")
    private String accountNumber;
}
