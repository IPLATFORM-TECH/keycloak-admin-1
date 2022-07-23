package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.commons.TimeUtils;
import space.eliseev.keycloakadmin.entity.Event;
import space.eliseev.keycloakadmin.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;


    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getById(@NonNull final String id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> getByUsername(@NonNull String username) {
        return eventRepository.findByUsername(username);
    }

    @Override
    public List<Event> getByDate(@NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd) {
        return eventRepository.findByDate(TimeUtils.toLong(timeStart), TimeUtils.toLong(timeEnd));
    }

    @Override
    public List<Event> getByUsernameAndDte(@NonNull String username, @NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd) {
        return eventRepository.findByUsernameAndDate(username, TimeUtils.toLong(timeStart), TimeUtils.toLong(timeEnd));
    }

}
