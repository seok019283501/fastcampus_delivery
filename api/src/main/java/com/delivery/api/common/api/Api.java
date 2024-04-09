package com.delivery.api.common.api;

import com.delivery.api.common.error.ErrorCodeItf;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result;

    @Valid
    private T body;

    public static <T> Api<T> OK(T data){
        var api = new Api<T>();
        api.result = Result.OK();
        api.body = data;
        return api;
    }
    public static Api<Object> ERROR(Result result){
        var api = new Api<Object>();
        api.result = Result.OK();
        return api;
    }
    public static Api<Object> ERROR(ErrorCodeItf errorCodeItf){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeItf);
        return api;
    }
    public static Api<Object> ERROR(ErrorCodeItf errorCodeItf,Throwable throwable){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeItf,throwable);
        return api;
    }
    public static Api<Object> ERROR(ErrorCodeItf errorCodeItf,String description){
        var api = new Api<Object>();
        api.result = Result.ERROR(errorCodeItf,description);
        return api;
    }
}
