package com.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

//user의 경우 1000번대 에러 사용
@AllArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCodeItf {

    USER_NOT_FOUND(400, 1404, "user not found"),
    ;
    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;


}
