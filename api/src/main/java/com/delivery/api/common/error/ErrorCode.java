package com.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements ErrorCodeItf{

    OK(200, 200, "success"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(),400,"bad request"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500,"server error"),
    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512,"Null poin")
    ;
    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;


}
