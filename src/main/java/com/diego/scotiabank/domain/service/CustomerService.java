package com.diego.scotiabank.domain.service;

import com.diego.scotiabank.domain.model.dto.responses.customer.NewCustomerDto;
import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.domain.model.model.DetailCustomer;
import com.diego.scotiabank.persistence.repository.classes.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Customer> getAll() {
        return clienteRepositorio.getAll();
    }

    public NewCustomerDto save(Customer customer) {
        Customer existsCustomerByDocumentNumber = clienteRepositorio.findByDocumentNumber(customer.getDocumentNumber()).orElse(null);
        if (existsCustomerByDocumentNumber == null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
            return new NewCustomerDto(true, null, clienteRepositorio.save(customer));
        } else {
            List<String> errors = new ArrayList<>();
            errors.add("El número de documento ingresado ya existe");
            return new NewCustomerDto(false, errors, null);
        }
    }

}
