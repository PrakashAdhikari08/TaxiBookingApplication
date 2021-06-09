package com.example.taxibookingapplication.testsupport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.MySQLContainer;

@Profile("test-container")
@Configuration
public class TestContainerConfiguration {

    private static final MySQLContainer MY_SQL_CONTAINER = initContainer();

    public static MySQLContainer initContainer(){

        MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest")
                .withDatabaseName("taxidb")
                .withPassword("")
                .withUsername("");
        return mySQLContainer;
    }

    @Bean
    public MySQLContainer mySQLContainer(){
        return MY_SQL_CONTAINER;
    }

}
