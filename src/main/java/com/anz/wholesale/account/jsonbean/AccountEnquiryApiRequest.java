package com.anz.wholesale.account.jsonbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEnquiryApiRequest implements Serializable {

    private String clientReqId;
}
