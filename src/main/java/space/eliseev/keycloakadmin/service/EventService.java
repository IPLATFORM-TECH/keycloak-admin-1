package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface EventService {
    List<EventDto> getAllEvents();

    Optional<EventDto> getById(@NonNull String id);

    Optional<EventDto> getByUsername(@NonNull String username);

    List<EventDto> getByDate(@NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd);

    List<EventDto> getByUsernameAndDte(@NonNull String username, @NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd);
}
