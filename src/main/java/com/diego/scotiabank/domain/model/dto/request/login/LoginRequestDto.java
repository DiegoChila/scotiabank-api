package com.diego.scotiabank.domain.model.dto.request.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequestDto {
    @NotNull(message = "El número de documento no puede ser vacío")
    @Size(min = 4, max = 20, message = "El número de documento debe contener entre 4 y 20 caracteres")
    private String documentNumber;

    @NotNull(message = "La contraseña no puede ser vacía")
    @Size(min = 4,  message = "La contraseña debe contener mínimo 4 caracteres")
    private String password;

    public LoginRequestDto(String documentNumber, String password) {
        this.documentNumber = documentNumber;
        this.password = password;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
