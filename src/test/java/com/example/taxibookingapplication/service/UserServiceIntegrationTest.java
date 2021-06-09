package com.example.taxibookingapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.net.URI;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles= {"test", "test-container"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class UserServiceIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getListOfAllUser(){

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List> response = testRestTemplate.exchange(URI.create("/taxi/user/get/all"), HttpMethod.GET, entity,List.class);
        log.info(response.toString());
    }

}
