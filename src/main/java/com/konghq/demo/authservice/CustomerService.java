package com.konghq.demo.authservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerService {

    @GetMapping("/customer/{customerId}/getOverview")
    public ResponseEntity<Customer> getOverview(@PathVariable("customerId") String customerId) {
        Customer customer = new Customer();
        customer.setCustId(customerId);
        customer.setCustomerName("Degui");
        customer.setCustomerCountry("Singapore");

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
}
