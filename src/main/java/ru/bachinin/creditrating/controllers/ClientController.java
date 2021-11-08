package ru.bachinin.creditrating.controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bachinin.creditrating.DTO.ClientDTO;
import ru.bachinin.creditrating.entities.Client;
import ru.bachinin.creditrating.repositories.ClientRepository;

import java.io.File;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private static final Integer STARTING_RATING = 10;

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping()
    public Integer calculateRating(@RequestBody String filePath) {

        ClientDTO clientDTO = restoreFromXml(filePath);

        if (clientDTO != null) {
            Client client = clientRepository.findClientBySurnameAndFirstNameAndSecondName(clientDTO.getSurname(), clientDTO.getFirstName(), clientDTO.getSecondName());

            if (client == null) {
                client = new Client();
                client.setSurname(clientDTO.getSurname());
                client.setFirstName(clientDTO.getFirstName());
                client.setSecondName(clientDTO.getSecondName());
                client.setRating(STARTING_RATING);

            } else {
                Integer newRating = client.getRating() + (-10 + (int) (Math.random() * 30));
                client.setRating(newRating);
            }
            clientRepository.save(client);
            return client.getRating();
        }
        return null;
    }

    private ClientDTO restoreFromXml(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(ClientDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return  (ClientDTO) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
