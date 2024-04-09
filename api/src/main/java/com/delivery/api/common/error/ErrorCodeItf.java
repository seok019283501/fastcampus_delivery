package com.delivery.api.common.error;

public interface ErrorCodeItf {
    Integer getHttpStatusCode();
    Integer getErrorCode();
    String getDescription();
}
