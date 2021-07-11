package com.diego.scotiabank.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    private String contrasena;

    @OneToOne(mappedBy = "cliente")
    private DetalleCliente detalleCliente;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public DetalleCliente getDetalleCliente() {
        return detalleCliente;
    }

    public void setDetalleCliente(DetalleCliente detalleCliente) {
        this.detalleCliente = detalleCliente;
    }
}
