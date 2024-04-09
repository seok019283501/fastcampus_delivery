package com.delivery.api.common.api;

import com.delivery.api.common.error.ErrorCode;
import com.delivery.api.common.error.ErrorCodeItf;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer resultCode;
    private String resultMessage;
    private String resultDescription;
    public static Result OK(){
        return Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode())
                .resultMessage(ErrorCode.OK.getDescription())
                .resultDescription("success")
                .build();
    }
    public static Result ERROR(ErrorCodeItf errorCodeItf){
        return Result.builder()
                .resultCode(errorCodeItf.getErrorCode())
                .resultMessage(errorCodeItf.getDescription())
                .resultDescription("ERROR")
                .build();
    }
    public static Result ERROR(ErrorCodeItf errorCodeItf,Throwable tx){
        return Result.builder()
                .resultCode(errorCodeItf.getErrorCode())
                .resultMessage(errorCodeItf.getDescription())
                .resultDescription(tx.getLocalizedMessage())
                .build();
    }
    public static Result ERROR(ErrorCodeItf errorCodeItf,String description){
        return Result.builder()
                .resultCode(errorCodeItf.getErrorCode())
                .resultMessage(errorCodeItf.getDescription())
                .resultDescription(description)
                .build();
    }
}
