package com.diego.scotiabank.persistence.mapper;

import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "clienteId", target = "customerId"),
            @Mapping(source = "numeroDocumento", target = "documentNumber"),
            @Mapping(source = "contrasena", target = "password"),
    })
    Customer toCustomer(Cliente cliente);
    List<Customer> toCustomers(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "detalleCliente", ignore = true)
    Cliente toCliente(Customer customer);
}
