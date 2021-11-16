package ru.bachinin.creditrating;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bachinin.creditrating.DTO.ClientDTO;
import ru.bachinin.creditrating.entities.Client;
import ru.bachinin.creditrating.mappers.ClientDTOMapper;
import ru.bachinin.creditrating.repositories.ClientRepository;
import ru.bachinin.creditrating.services.ClientService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientDTOMapper clientDTOMapper;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void getNewRatingOfPositiveNumber() {
        // Arrange
        Integer number = 10;

        // Act
        Integer rating = clientService.calculateRating(number);

        // Assert
        assertNotEquals(number, rating);
    }

    @Test
    public void getNewRatingOfNegativeNumber() {
        // Arrange
        Integer number = -10;

        // Act
        Integer rating = clientService.calculateRating(number);

        // Assert
        assertNotEquals(number, rating);
    }

    @Test
    public void getNewRatingOfZero() {
        // Arrange
        Integer number = 0;

        // Act
        Integer rating = clientService.calculateRating(number);

        // Assert
        assertNotEquals(number, rating);
    }

    @Test
    public void getRatingOfNewClient() {
        // Arrange
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setSurname("surname");
        clientDTO.setFirstName("firstName");
        clientDTO.setSecondName("secondName");

        Mockito.when(clientDTOMapper.clientDTOToClient(clientDTO))
                .thenReturn(new Client("surname", "firstName", "secondName"));

        // Act
        Client client = clientService.createClientFromDto(clientDTO);

        // Assert
        assertEquals(client.getRating(), 10);
    }
}
