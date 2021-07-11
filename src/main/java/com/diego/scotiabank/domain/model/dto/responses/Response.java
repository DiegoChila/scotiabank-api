package com.diego.scotiabank.domain.model.dto.responses;

import java.util.List;

public class Response {
    public boolean success;
    public List<String> errors;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
