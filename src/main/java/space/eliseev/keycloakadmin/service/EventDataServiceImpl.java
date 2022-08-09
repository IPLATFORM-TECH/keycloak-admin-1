package space.eliseev.keycloakadmin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventDataServiceImpl implements EventDataService {
    private final EventRepository eventRepository;

    @Override
    public String getUsername() {
        return eventRepository.findByUserId();
    }

    @Override
    public String getClientName() {
        return eventRepository.findByClientId();
    }

    @Override
    public String getRealmName() {
        return eventRepository.findByRealmId();
    }


}
