package com.example.taxibookingapplication.payment;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

        ResponseEntity<String> responseEntity = restTemplate.exchange(paymentServiceUrl+"/payment-register",
                HttpMethod.POST, entity, String.class);
        return new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());

    }

    @PostMapping("/payment/booking/{bookingId}")
    public ResponseEntity<String> paymentRequest(@RequestBody PaymentRequestDto paymentRequestDto,
                                                 @PathVariable Integer bookingId){
        paymentRequestDto.setBookingId(bookingId);
        paymentRequestDto.getCustomerId();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PaymentRequestDto> entity = new HttpEntity<>(paymentRequestDto, httpHeaders);

        String url = paymentServiceUrl + "/payment/booking/" + bookingId;
        log.info(url);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class );

//        if (responseEntity.get)
//            return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.NOT_FOUND);
        return  new ResponseEntity(responseEntity.getBody(), responseEntity.getStatusCode());
    }

    @GetMapping(value = "/payment/getAll/{customerId}")
    public ResponseEntity<List<PaymentRecord>> getAllPayment(@PathVariable Integer customerId){
        //        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity <String> entity = new HttpEntity<String>(headers);
        List<PaymentRecord> paymentRecords = restTemplate.getForObject(paymentServiceUrl + "/payment/getAll/" + customerId, List.class);

        return new ResponseEntity<>(paymentRecords, HttpStatus.OK);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleClientError(){
        return new ResponseEntity<>("Payment not complete", HttpStatus.NOT_FOUND);

    }
}
