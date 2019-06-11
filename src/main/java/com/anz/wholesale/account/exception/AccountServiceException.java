package com.anz.wholesale.account.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountServiceException extends Exception {

    private String requestId;
    private String errorCode;

}
