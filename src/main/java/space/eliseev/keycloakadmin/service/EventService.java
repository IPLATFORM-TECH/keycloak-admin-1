package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface EventService {
    List<Event> getAllEvents();

    Optional<Event> getById(@NonNull String id);

    Optional<Event> getByUsername(@NonNull String username);

    List<Event> getByDate(@NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd);

    List<Event> getByUsernameAndDte(@NonNull String username, @NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd);
}
