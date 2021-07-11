package com.diego.scotiabank.domain.model.dto.responses.customer;

import com.diego.scotiabank.domain.model.dto.responses.Response;
import com.diego.scotiabank.domain.model.model.Customer;

import java.util.List;

public class NewCustomerDto extends Response {
    private Customer customer;

    public NewCustomerDto(boolean success, List<String> errors, Customer customer) {
        this.customer = customer;
        this.errors = errors;
        this.success = success;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
