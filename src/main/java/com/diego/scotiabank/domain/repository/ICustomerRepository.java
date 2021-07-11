package com.diego.scotiabank.domain.repository;

import com.diego.scotiabank.domain.model.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    List<Customer> getAll();
    Optional<Customer> findByDocumentNumber(String documentNumber);
    Customer save(Customer customer);
    Optional<Customer> findById(Long customerId);
}
