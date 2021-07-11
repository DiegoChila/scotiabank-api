package com.diego.scotiabank.security.services;

import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.domain.service.CustomerService;
import com.diego.scotiabank.persistence.repository.classes.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public UserDetails loadUserByUsername(String documentNumber) throws UsernameNotFoundException {
        Customer customer = clienteRepositorio.findByDocumentNumber(documentNumber).orElse(null);
        if (customer != null) {
            return new org.springframework.security.core.userdetails.User(customer.getDocumentNumber(), customer.getPassword(), new ArrayList<>());
        }
        return null;
    }
}
