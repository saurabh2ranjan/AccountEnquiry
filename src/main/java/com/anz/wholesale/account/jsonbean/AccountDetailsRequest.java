package com.anz.wholesale.account.jsonbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AccountDetailsRequest implements Serializable {

    @NotNull(message = "User Id cannot be null.")
    private String userId;

}
