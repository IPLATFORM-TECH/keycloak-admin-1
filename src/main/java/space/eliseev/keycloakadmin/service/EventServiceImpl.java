package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Event;
import space.eliseev.keycloakadmin.repository.EventRepository;

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
    public List<Event> getByDate(@NonNull Long timeStart, @NonNull Long timeEnd) {
        return eventRepository.findByDate(timeStart, timeEnd);
    }

    @Override
    public List<Event> getByUsernameAndDte(@NonNull String username, @NonNull Long timeStart, @NonNull Long timeEnd) {
       return eventRepository.findByUsernameAndDate(username, timeStart, timeEnd);
    }

}
