package space.eliseev.keycloakadmin.mapper;

import org.mapstruct.Mapper;
import space.eliseev.keycloakadmin.dto.EventDto;
import space.eliseev.keycloakadmin.entity.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);
}
