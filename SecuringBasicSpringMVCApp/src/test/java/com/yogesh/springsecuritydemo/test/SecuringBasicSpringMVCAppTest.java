package com.yogesh.springsecuritydemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.yogesh.springsecuritydemo.spring.SecuringBasicSpringMVCApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecuringBasicSpringMVCApp.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SecuringBasicSpringMVCAppTest {

    @Test
    public void whenLoadApplication_thenSuccess() {

    }
}
