package com.konghq.demo.authservice;

import io.micrometer.core.ipc.http.HttpSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    @PostMapping("/auth/validate/token")
    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token) {
        logger.info("token: " + token);

        if (token.indexOf("XXX") > -1) {
            return ResponseEntity.status(HttpStatus.OK).body("Okay");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access denied");
        }
    }

    @PostMapping("/auth/validate/customer")
    public ResponseEntity<String> validateCustomer(@RequestHeader("Authorization") String token,
                                                   @RequestBody Customer customer) {
        logger.info("customer ID: " + customer.getCustId());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("new-jwt-token",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");

       if (customer.getCustId().indexOf("xudegui") > -1) {
           return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body("Okay");
       } else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access denied");
       }
    }
}
