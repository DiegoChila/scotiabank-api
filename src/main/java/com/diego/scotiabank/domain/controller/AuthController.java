package com.diego.scotiabank.domain.controller;

import com.diego.scotiabank.domain.model.dto.request.login.LoginRequestDto;
import com.diego.scotiabank.domain.model.dto.responses.customer.NewCustomerDto;
import com.diego.scotiabank.domain.model.dto.responses.login.LoginDto;
import com.diego.scotiabank.domain.model.model.Customer;
import com.diego.scotiabank.domain.service.AuthService;
import com.diego.scotiabank.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public NewCustomerDto save(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectsErrors = bindingResult.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new NewCustomerDto(false, errors, null);
        } else {
            return customerService.save(customer);
        }
    }

    @PostMapping("/login")
    public LoginDto login(@RequestBody @Valid LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectsErrors = bindingResult.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new LoginDto(false, errors, null, null);
        } else {
            return authService.login(loginRequestDto);
        }
    }


}
