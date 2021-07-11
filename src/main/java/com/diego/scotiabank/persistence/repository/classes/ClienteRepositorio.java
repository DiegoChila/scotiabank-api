package com.diego.scotiabank.persistence.repository.classes;

import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.domain.repository.ICustomerRepository;
import com.diego.scotiabank.persistence.entity.Cliente;
import com.diego.scotiabank.persistence.mapper.CustomerMapper;
import com.diego.scotiabank.persistence.repository.crud.ClienteCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositorio implements ICustomerRepository {
    @Autowired
    private ClienteCrud clienteCrud;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAll() {
        return customerMapper.toCustomers((List<Cliente>) clienteCrud.findAll());
    }

    @Override
    public Optional<Customer> findByDocumentNumber(String documentNumber) {
        return clienteCrud.findByNumeroDocumento(documentNumber).map(cliente -> customerMapper.toCustomer(cliente));
    }

    @Override
    public Customer save(Customer customer) {
        return customerMapper.toCustomer(clienteCrud.save(customerMapper.toCliente(customer)));
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return clienteCrud.findById(customerId).map(cliente -> customerMapper.toCustomer(cliente));
    }
}
