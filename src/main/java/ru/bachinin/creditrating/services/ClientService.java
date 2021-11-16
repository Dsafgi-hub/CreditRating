package ru.bachinin.creditrating.services;

import org.springframework.stereotype.Service;
import ru.bachinin.creditrating.DTO.ClientDTO;
import ru.bachinin.creditrating.entities.Client;
import ru.bachinin.creditrating.mappers.ClientDTOMapper;
import ru.bachinin.creditrating.repositories.ClientRepository;

@Service
public class ClientService {
    private static final Integer STARTING_RATING = 10;

    private final ClientRepository clientRepository;
    private final ClientDTOMapper clientDTOMapper;

    public ClientService(ClientRepository clientRepository,
                         ClientDTOMapper clientDTOMapper) {
        this.clientRepository = clientRepository;
        this.clientDTOMapper = clientDTOMapper;
    }

    public Client createClientFromDto(ClientDTO clientDTO) {
        Client client = clientRepository.findClientBySurnameAndFirstNameAndSecondName(clientDTO.getSurname(), clientDTO.getFirstName(), clientDTO.getSecondName());

        if (client == null) {
            client = clientDTOMapper.clientDTOToClient(clientDTO);
            client.setRating(STARTING_RATING);
        } else {
            client.setRating(calculateRating(client.getRating()));
        }

        clientRepository.save(client);
        return client;
    }

    public Integer calculateRating(Integer rating) {
        if (rating > 0) {
            return rating - (1 + (int) (Math.random() * 10));
        } else {
            return rating + (1 + (int) (Math.random() * 10));
        }
    }
}
