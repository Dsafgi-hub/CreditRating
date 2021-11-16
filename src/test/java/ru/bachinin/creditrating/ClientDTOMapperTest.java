package ru.bachinin.creditrating;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import ru.bachinin.creditrating.DTO.ClientDTO;
import ru.bachinin.creditrating.entities.Client;
import ru.bachinin.creditrating.mappers.ClientDTOMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientDTOMapperTest {

    @Autowired
    private ClientDTOMapper clientDTOMapper;

    ClientDTO clientDTO;

    // Arrange
    @BeforeEach
    public void setUp() {
        clientDTO = new ClientDTO();
        clientDTO.setSurname("surname");
        clientDTO.setFirstName("firstName");
        clientDTO.setSecondName("secondName");
    }

    @Test
    public void getClientSurnameFromClientDTO() {
        // Act
        Client client = clientDTOMapper.clientDTOToClient(clientDTO);

        // Assert
        assertEquals(client.getSurname(), clientDTO.getSurname());
    }

    @Test
    public void getClientFirstNameFromClientDTO() {
        // Act
        Client client = clientDTOMapper.clientDTOToClient(clientDTO);

        // Assert
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
    }

    @Test
    public void getClientSecondNameFromClientDTO() {
        // Act
        Client client = clientDTOMapper.clientDTOToClient(clientDTO);

        // Assert
        assertEquals(client.getSecondName(), clientDTO.getSecondName());
    }
}
