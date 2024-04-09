package com.delivery.api.common.exception;

import com.delivery.api.common.error.ErrorCodeItf;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException implements ApiExecptionIfs {
    private final ErrorCodeItf errorCodeIfs;
    private final String errorDescription;
    public ApiException(ErrorCodeItf errorCodeItf){
        super(errorCodeItf.getDescription());
        this.errorCodeIfs = errorCodeItf;
        this.errorDescription = errorCodeItf.getDescription();
    }
    public ApiException(ErrorCodeItf errorCodeItf,String errorDescription){
        super(errorDescription);
        this.errorCodeIfs = errorCodeItf;
        this.errorDescription = errorDescription;
    }
    public ApiException(ErrorCodeItf errorCodeItf,Throwable throwable){
        super(throwable);
        this.errorCodeIfs = errorCodeItf;
        this.errorDescription = errorCodeItf.getDescription();
    }
    public ApiException(ErrorCodeItf errorCodeItf,Throwable throwable,String errorDescription){
        super(throwable);
        this.errorCodeIfs = errorCodeItf;
        this.errorDescription = errorDescription;
    }
}
