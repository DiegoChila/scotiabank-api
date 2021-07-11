package com.diego.scotiabank.persistence.mapper;

import com.diego.scotiabank.domain.model.model.DetailCustomer;
import com.diego.scotiabank.persistence.entity.DetalleCliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailCustomerMapper {
    @Mappings({
            @Mapping(source = "detalleId", target = "detailId"),
            @Mapping(source = "clienteId", target = "costumerId"),
            @Mapping(source = "nombres", target = "name"),
            @Mapping(source = "apellidos", target = "lastname"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "profesion", target = "profession"),
    })
    DetailCustomer toDetailCustomer(DetalleCliente detalleCliente);
    List<DetailCustomer> toDetailCustomers(List<DetalleCliente> detalleClientes);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    DetalleCliente toDetalleCliente(DetailCustomer detailCustomer);
}
