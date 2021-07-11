package com.diego.scotiabank.persistence.repository.crud;

import com.diego.scotiabank.persistence.entity.DetalleCliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DetalleClienteCrud extends CrudRepository<DetalleCliente, Long> {
    Optional<DetalleCliente> findByClienteId(Long clienteId);
}
