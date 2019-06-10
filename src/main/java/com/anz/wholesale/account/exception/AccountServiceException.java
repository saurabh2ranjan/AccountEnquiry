package com.anz.wholesale.account.exception;

import lombok.Builder;

//@Builder
public class AccountServiceException extends Exception {

    private String requestId;
    private String errorCode;

    public AccountServiceException(String message){
        super(message);
    }

    public AccountServiceException(final String message, final Throwable throwable){
        super(message,throwable);
    }

    public AccountServiceException(String requestId, String message, String errorCode){
        super(message);
        this.requestId= requestId;
        this.errorCode = errorCode;
    }


}
