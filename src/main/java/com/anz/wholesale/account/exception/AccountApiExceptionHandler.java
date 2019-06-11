package com.anz.wholesale.account.exception;

import com.anz.wholesale.account.constant.AccountEnquiryConstants;
import com.anz.wholesale.account.jsonbean.AccountEnquiryError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class AccountApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
        //@ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
       /* AccountEnquiryErrorResponse errorResponse =
                new AccountEnquiryErrorResponse(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), errors);
        return new ResponseEntity<Object>(
                errorResponse, new HttpHeaders(), apiError.getStatus());*/
        e.printStackTrace();
        return new ResponseEntity<>("Validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

   /* @ExceptionHandler(RuntimeException.class)
        //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<String> handleConstraintViolationException(RuntimeException e) {
        e.printStackTrace();
        log.error("Error:" + e.getMessage());
        return new ResponseEntity<>("Application Error. If persists contact helpdesk.", HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    /**
     * Handler method for malformed Json request.
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Malformed Request.Error:"+ ex.getMessage());
        return buildResponseEntity(AccountEnquiryError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(AccountEnquiryConstants.ERR_MSG_MALFORMED_REQUEST)
                .debugMessage(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    /**
     * Handler method for invalid request fields. e.g. null-check, format-check
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.error("Invalid request field.Error:"+ ex.getMessage());
        return buildResponseEntity(AccountEnquiryError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(AccountEnquiryConstants.ERR_MSG_CLIENT_REQ_ID_MISSING)
                .debugMessage(ex.getLocalizedMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    /**
     * Handler method for no entity found.
     * @param ex
     * @return
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        logger.error("Entity Not Found.Error:"+ex.getMessage());
        return buildResponseEntity(AccountEnquiryError.builder()
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build());
    }

    /**
     * Handler method for Unexpected error
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleException(Exception ex) {
        logger.error("Unexpected error:"+ex.getMessage());
        return buildResponseEntity(AccountEnquiryError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build());
    }

    private ResponseEntity<Object> buildResponseEntity(AccountEnquiryError accountEnquiryError) {
        return new ResponseEntity<>(accountEnquiryError, accountEnquiryError.getStatus());
    }
}