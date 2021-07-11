package com.diego.scotiabank.domain.model.dto.responses.login;

import com.diego.scotiabank.domain.model.dto.responses.Response;

import java.util.List;

public class LoginDto extends Response {
    private String token;
    private Long customerId;

    public LoginDto(boolean success, List<String> errors, String token, Long customerId) {
        this.token = token;
        this.errors = errors;
        this.success = success;
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
