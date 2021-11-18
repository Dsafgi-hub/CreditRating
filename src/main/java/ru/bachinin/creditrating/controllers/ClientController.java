package ru.bachinin.creditrating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bachinin.creditrating.DTO.ClientDTO;
import ru.bachinin.creditrating.entities.Client;
import ru.bachinin.creditrating.services.ClientService;

import javax.validation.Valid;

@RestController
@RequestMapping
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients", consumes = {MediaType.APPLICATION_XML_VALUE})
    public Integer calculateRating(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = clientService.createClientFromDto(clientDTO);
        return client.getRating();
    }
}
