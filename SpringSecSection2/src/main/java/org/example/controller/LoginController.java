package org.example.controller;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        try {
            customer=customerRepository.save(customer);
            if(customer.getId()>0){
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body("User is successfully registered");
            }
             return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User is not  successfully registered :"+customer);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CREATED)
                        .body("An exception occurred "+e.getMessage() );
        }
    }
}
