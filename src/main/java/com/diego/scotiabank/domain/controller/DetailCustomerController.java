package com.diego.scotiabank.domain.controller;

import com.diego.scotiabank.domain.model.dto.responses.detailCustomer.DetailCustomerDto;
import com.diego.scotiabank.domain.model.dto.responses.login.LoginDto;
import com.diego.scotiabank.domain.model.model.DetailCustomer;
import com.diego.scotiabank.domain.service.DetailCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*")
public class DetailCustomerController {
    @Autowired
    private DetailCustomerService detailCustomerService;

    @GetMapping("/{customerId}")
    public DetailCustomerDto getDetailCustomer(@PathVariable("customerId") Long customerId) {
        return detailCustomerService.getByCustomerId(customerId);
    }

    @PostMapping
    public DetailCustomerDto save(@RequestBody @Valid DetailCustomer detailCustomer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectsErrors = bindingResult.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            errors.add("inicio");
            return new DetailCustomerDto(false, errors, detailCustomer);
        } else {
            return detailCustomerService.save(detailCustomer);
        }
    }
}
