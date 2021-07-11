package com.diego.scotiabank.persistence.repository.classes;

import com.diego.scotiabank.domain.model.model.DetailCustomer;
import com.diego.scotiabank.domain.repository.IDetailCustomerRepository;
import com.diego.scotiabank.persistence.entity.DetalleCliente;
import com.diego.scotiabank.persistence.mapper.DetailCustomerMapper;
import com.diego.scotiabank.persistence.repository.crud.DetalleClienteCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public class DetalleClienteRepositorio implements IDetailCustomerRepository {
    @Autowired
    private DetalleClienteCrud detalleClienteCrud;

    @Autowired
    private DetailCustomerMapper detailCustomerMapper;

    @Override
    public List<DetailCustomer> getAll() {
        return detailCustomerMapper.toDetailCustomers((List<DetalleCliente>) detalleClienteCrud.findAll());
    }

    @Override
    public Optional<DetailCustomer> findByCostumerId(Long customerId) {
        return detalleClienteCrud.findByClienteId(customerId).map(detail -> detailCustomerMapper.toDetailCustomer(detail));
    }

    @Override
    public DetailCustomer save(DetailCustomer detailCustomer) {
        return detailCustomerMapper.toDetailCustomer(detalleClienteCrud.save(detailCustomerMapper.toDetalleCliente(detailCustomer)));
    }
}
