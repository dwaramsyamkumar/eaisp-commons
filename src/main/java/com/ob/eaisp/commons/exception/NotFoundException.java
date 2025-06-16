package com.ob.eaisp.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends HttpException{
    public NotFoundException(ErrorData.Error error) {
        super(error.getErrorCode(), error.getMessage(), HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }
}
