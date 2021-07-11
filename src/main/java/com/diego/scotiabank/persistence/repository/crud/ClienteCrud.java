package com.diego.scotiabank.persistence.repository.crud;

import com.diego.scotiabank.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteCrud extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}
