package com.geupjo.koreantiger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KoreanTigerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KoreanTigerApplication.class, args);
    }

}
