package ru.bachinin.creditrating.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.bachinin.creditrating.entities.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
    Client findClientBySurnameAndFirstNameAndSecondName(String surname, String firstName, String secondName);
}
