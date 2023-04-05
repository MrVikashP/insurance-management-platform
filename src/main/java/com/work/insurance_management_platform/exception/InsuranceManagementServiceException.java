package com.work.insurance_management_platform.exception;

import com.work.insurance_management_platform.exception.errorCode.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InsuranceManagementServiceException extends RuntimeException{
    private Integer errorCode;
    private String errorMessage;

    public InsuranceManagementServiceException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorCode.getErrorMessage();
    }


    public InsuranceManagementServiceException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorMessage;
    }

    public InsuranceManagementServiceException(String errorMessage) {
        super(errorMessage);
        this.errorCode = ErrorCode.BAD_REQUEST.getCode();
        this.errorMessage = errorMessage;
    }

    public InsuranceManagementServiceException(Integer customErrorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = customErrorCode;
        this.errorMessage = errorMessage;
    }

}
