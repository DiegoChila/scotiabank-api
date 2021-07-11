package com.diego.scotiabank.domain.service;

import com.diego.scotiabank.domain.model.dto.request.login.LoginRequestDto;
import com.diego.scotiabank.domain.model.dto.responses.login.LoginDto;
import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.persistence.repository.classes.ClienteRepositorio;
import com.diego.scotiabank.security.JwtUtil;
import com.diego.scotiabank.security.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginDto login(LoginRequestDto loginRequestDto) {
        Customer customer = clienteRepositorio.findByDocumentNumber(loginRequestDto.getDocumentNumber()).orElse(null);
        List<String> errors = new ArrayList<>();
        if (customer != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if (bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), customer.getPassword())) {
                UserDetails userDetails = userDetailService.loadUserByUsername(customer.getDocumentNumber());
                String token = jwtUtil.generateToken(userDetails);
                return new LoginDto(true, null, token, customer.getCustomerId());
            } else {
                errors.add("Contraseña incorrecta");
                return new LoginDto(false, errors, null, null);
            }
        } else {
            errors.add("Usuario no existe");
            return new LoginDto(false, errors, null, null);
        }
    }
}
