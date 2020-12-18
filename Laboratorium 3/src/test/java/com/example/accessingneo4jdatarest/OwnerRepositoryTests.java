package com.example.accessingneo4jdatarest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerRepositoryTests {

    @Autowired
    private OwnerRepository repository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(repository).isNotNull();
    }

}
