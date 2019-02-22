package com.oppo.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
public class EsApplication implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class, args);
    }

}

