package com.work.insurance_management_platform.exception.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    private boolean success = true;
    private Integer code;
    private Integer errorCode;
    private String errorMessage;
    private T data;

    public ApiResponse(HttpStatus ok, T data, String successfully_updated_snOrgProfile) {
        this.data = data;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



}
