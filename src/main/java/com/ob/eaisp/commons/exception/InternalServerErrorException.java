package com.ob.eaisp.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InternalServerErrorException extends HttpException{
    public InternalServerErrorException(ErrorData.Error error) {
        super(error.getErrorCode(),error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(String code, String message) {
        super(code, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}