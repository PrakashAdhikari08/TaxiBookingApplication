package com.example.taxibookingapplication.payment;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@Slf4j
public class PaymentController {

    @Value("${payment.register.url}")
    private String paymentServiceUrl;

    private RestTemplate restTemplate;

    public PaymentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostMapping("/register/{customerId}")
    public ResponseEntity<String> addCard(@RequestBody Payment payment, @PathVariable Integer customerId){

        payment.setCustomerId(customerId);
        log.info(paymentServiceUrl);

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Payment> entity = new HttpEntity<>(payment, headers);

        return restTemplate.exchange(paymentServiceUrl+"/payment-register", HttpMethod.POST, entity, String.class);

//        return new ResponseEntity("Card Details Saved", HttpStatus.OK);

    }
}
