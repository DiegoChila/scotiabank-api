package com.diego.scotiabank.domain.model.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DetailCustomer {
    private Long detailId;

    @NotNull(message = "Debe indicar el cliente")
    private Long costumerId;

    @NotNull(message = "El nombre no puede ser vacío")
    @Size(min = 4, max = 30, message = "El nombre debe contener entre 4 y 30 caracteres")
    private String name;

    @NotNull(message = "El apellido no puede ser vacío")
    @Size(min = 4, max = 30, message = "El apellido debe contener entre 4 y 30 caracteres")
    private String lastname;

    @NotNull(message = "La dirección no puede ser vacía")
    @Size(min = 4, max = 30, message = "La dirección debe contener entre 4 y 30 caracteres")
    private String address;

    @NotNull(message = "El número de teléfono no puede ser vacío")
    @Size(min = 4, max = 20, message = "El número de teléfono debe contener entre 4 y 20 caracteres")
    private String phone;

    @NotNull(message = "La profesión no puede ser vacía")
    @Size(min = 4, max = 30, message = "La profesión debe contener entre 4 y 30 caracteres")
    private String profession;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
