package com.pavasa.pse.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")

public class PavasaPseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PavasaPseApiApplication.class, args);
    }

}
