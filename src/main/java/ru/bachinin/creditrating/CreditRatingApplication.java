package ru.bachinin.creditrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class CreditRatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditRatingApplication.class, args);
    }

}
