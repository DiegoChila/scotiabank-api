package com.diego.scotiabank.domain.model.dto.responses.detailCustomer;

import com.diego.scotiabank.domain.model.dto.responses.Response;
import com.diego.scotiabank.domain.model.model.DetailCustomer;

import java.util.List;

public class DetailCustomerDto extends Response {
    private DetailCustomer detailCustomer;

    public DetailCustomerDto(boolean success, List<String> errors, DetailCustomer detailCustomer) {
        this.detailCustomer = detailCustomer;
        this.errors = errors;
        this.success = success;
    }

    public DetailCustomer getDetailCustomer() {
        return detailCustomer;
    }

    public void setDetailCustomer(DetailCustomer detailCustomer) {
        this.detailCustomer = detailCustomer;
    }
}
