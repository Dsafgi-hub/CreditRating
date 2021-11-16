package ru.bachinin.creditrating.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.bachinin.creditrating.DTO.ClientDTO;
import ru.bachinin.creditrating.entities.Client;

@Component
@Mapper(componentModel = "spring")
public interface ClientDTOMapper {
        Client clientDTOToClient(ClientDTO clientDTO);
}
