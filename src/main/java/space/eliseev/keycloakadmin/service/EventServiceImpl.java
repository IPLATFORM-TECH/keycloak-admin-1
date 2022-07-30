package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.commons.TimeUtils;
import space.eliseev.keycloakadmin.dto.EventDto;
import space.eliseev.keycloakadmin.entity.Event;
import space.eliseev.keycloakadmin.mapper.EventMapper;
import space.eliseev.keycloakadmin.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<EventDto> getById(@NonNull final String id) {
        return Optional.ofNullable(eventMapper.toDto(eventRepository.findById(id).orElse(new Event())));
    }

    @Override
    public Optional<EventDto> getByUsername(@NonNull String username) {
        return Optional.ofNullable(eventMapper.toDto(eventRepository.findByUsername(username).orElse(new Event())));
    }

    @Override
    public List<EventDto> getByDate(@NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd) {
        return eventRepository.findByDate(TimeUtils.toLong(timeStart), TimeUtils.toLong(timeEnd)).stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getByUsernameAndDte(@NonNull String username, @NonNull LocalDateTime timeStart, @NonNull LocalDateTime timeEnd) {
        return eventRepository.findByUsernameAndDate(username, TimeUtils.toLong(timeStart), TimeUtils.toLong(timeEnd)).stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

}
