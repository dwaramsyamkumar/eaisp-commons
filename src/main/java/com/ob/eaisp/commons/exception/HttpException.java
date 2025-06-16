package com.ob.eaisp.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException {
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    public HttpException(String code, String message,HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
    public ErrorData.Error getError() {
        return new ErrorData.Error(code, message);
    }
}
