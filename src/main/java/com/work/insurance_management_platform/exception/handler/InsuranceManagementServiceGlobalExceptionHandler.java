package com.work.insurance_management_platform.exception.handler;

import com.work.insurance_management_platform.exception.ApplicationException;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.exception.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.ws.rs.BadRequestException;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice(basePackages = {"com.organization"})
@Slf4j
public class InsuranceManagementServiceGlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse handleException(ApplicationException ex) {
        ApiResponse apiOutput = getApiResponse(ex);
        log.error("Exception occurred", ex);
        return apiOutput;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse handleException(BadRequestException ex) {
        String errorMsg = ex.getLocalizedMessage() == null ? "Error" : ex.getLocalizedMessage();
        ApiResponse apiOutput = new ApiResponse();
        apiOutput.setSuccess(false);
        apiOutput.setErrorMessage(errorMsg);
        log.error("Exception occurred", ex);
        return apiOutput;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ApiResponse handleException(Exception ex) {
        String errorMsg = INTERNAL_SERVER_ERROR +
                ":" + (ex.getLocalizedMessage() == null ? "Error" : ex.getLocalizedMessage());
        ApiResponse apiOutput = new ApiResponse();
        apiOutput.setSuccess(false);
        apiOutput.setErrorMessage(errorMsg);
        log.error("Exception occurred", ex);
        return apiOutput;
    }

    private ApiResponse getApiResponse(ApplicationException ex) {
        ApiResponse apiOutput = new ApiResponse();
        apiOutput.setSuccess(false);
        Integer errorCode = ex.getErrorCode();
        if (errorCode != null) {
            apiOutput.setErrorCode(ex.getErrorCode());
        }
        apiOutput.setErrorMessage(ex.getErrorMessage());
        return apiOutput;
    }

    @ExceptionHandler(InsuranceManagementServiceException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse handleException(InsuranceManagementServiceException ex) {
        String errorMsg = ex.getLocalizedMessage() == null ? "Error" : ex.getLocalizedMessage();
        ApiResponse apiOutput = new ApiResponse();
        apiOutput.setSuccess(false);
        apiOutput.setErrorMessage(errorMsg);
        log.error("Exception occurred", ex);
        return apiOutput;
    }


}
