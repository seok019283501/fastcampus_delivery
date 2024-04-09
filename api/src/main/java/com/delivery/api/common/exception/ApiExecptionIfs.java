package com.delivery.api.common.exception;

import com.delivery.api.common.error.ErrorCodeItf;

public interface ApiExecptionIfs {
    ErrorCodeItf getErrorCodeIfs();
    String getErrorDescription();
}
