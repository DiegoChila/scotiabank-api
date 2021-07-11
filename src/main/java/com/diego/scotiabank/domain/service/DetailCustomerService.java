package com.diego.scotiabank.domain.service;

import com.diego.scotiabank.domain.model.dto.responses.detailCustomer.DetailCustomerDto;
import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.domain.model.model.DetailCustomer;
import com.diego.scotiabank.persistence.repository.classes.ClienteRepositorio;
import com.diego.scotiabank.persistence.repository.classes.DetalleClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailCustomerService {
    @Autowired
    private DetalleClienteRepositorio detalleClienteRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<DetailCustomer> getAll() {
        return detalleClienteRepositorio.getAll();
    }

    public DetailCustomerDto getByCustomerId(Long customerId) {
        DetailCustomer detailCustomer = detalleClienteRepositorio.findByCostumerId(customerId).orElse(null);
        if (detailCustomer != null) {
            return new DetailCustomerDto(true, null, detailCustomer);
        } else {
            List<String> errors = new ArrayList<>();
            errors.add("No se encontraron datos del cliente");
            return new DetailCustomerDto(false, errors, null);
        }
    }

    public DetailCustomerDto save(DetailCustomer detailCustomer) {
        DetailCustomer detailCustomerExists = detalleClienteRepositorio.findByCostumerId(detailCustomer.getCostumerId()).orElse(null);
        if (detailCustomerExists == null) {
            Customer customer = clienteRepositorio.findById(detailCustomer.getCostumerId()).orElse(null);
            if (customer != null) {
                return new DetailCustomerDto(true, null, detalleClienteRepositorio.save(detailCustomer));
            } else {
                List<String> errors = new ArrayList<>();
                errors.add("El cliente no existe");
                return new DetailCustomerDto(false, errors, null);
            }
        } else {
            detailCustomerExists.setName(detailCustomer.getName());
            detailCustomerExists.setLastname(detailCustomer.getLastname());
            detailCustomerExists.setAddress(detailCustomer.getAddress());
            detailCustomerExists.setPhone(detailCustomer.getPhone());
            detailCustomerExists.setProfession(detailCustomer.getProfession());
            return new DetailCustomerDto(true, null, detalleClienteRepositorio.save(detailCustomerExists));
        }
    }
}
