package com.diego.scotiabank.domain.repository;

import com.diego.scotiabank.domain.model.model.DetailCustomer;

import java.util.List;
import java.util.Optional;

public interface IDetailCustomerRepository {
    List<DetailCustomer> getAll();
    Optional<DetailCustomer> findByCostumerId(Long customerId);
    DetailCustomer save(DetailCustomer detailCustomer);
}
