package space.eliseev.keycloakadmin.mapper;

import org.mapstruct.Mapper;
import space.eliseev.keycloakadmin.dto.ClientDto;
import space.eliseev.keycloakadmin.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDtoMapper(Client client);
    Client toEntityMapper(ClientDto clientDto);
}
