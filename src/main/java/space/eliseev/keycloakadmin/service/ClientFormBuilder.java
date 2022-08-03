package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.dto.ClientDto;

import java.util.List;

public interface ClientFormBuilder {
    byte[] download(@NonNull List<ClientDto> clients);
}
