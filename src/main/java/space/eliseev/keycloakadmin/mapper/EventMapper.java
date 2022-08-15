package space.eliseev.keycloakadmin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import space.eliseev.keycloakadmin.commons.TimeUtils;
import space.eliseev.keycloakadmin.dto.EventDto;
import space.eliseev.keycloakadmin.entity.Event;

@Mapper(componentModel = "spring", imports = TimeUtils.class)
public interface EventMapper {
    @Mapping(target = "eventTime", expression = "java(TimeUtils.toLocalDateTime(event.getEventTime()))")
    @Mapping(target = "userName", source = "user.username")
    EventDto toDto(Event event);

    @Mapping(target = "eventTime", expression = "java(TimeUtils.toLong(eventDto.getEventTime()))")
    Event toEntity(EventDto eventDto);
}
