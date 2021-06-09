package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Gender;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Slf4j
@RunWith(SpringRunner.class)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
@TestPropertySource(
           value = "classpath:application-test.yaml"
)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @SpyBean
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void getListOfAllUser(){

        User user = createUser();
        userRepository.save(user);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<List> response = testRestTemplate.exchange(URI.create("/taxi/user/get/all"), HttpMethod.GET, entity,List.class);
        log.info(response.toString());
        verify(userService).findAll();
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }

    private User createUser(){
        return User.builder().email("abc").password("222").firstName("Prakash").lastName("Adhikari").gender(Gender.MALE).
                build();
    }

}
