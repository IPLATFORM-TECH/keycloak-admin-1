package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.dto.EventDto;

import java.util.List;

public interface EventFromBuilder {
    byte[] downloadEvent(@NonNull List<EventDto> eventDto);
}
