package space.eliseev.keycloakadmin.service;

import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Event;

@Service
public interface EventDataService {
    String getUsername();

    String getClientName();

    String getRealmName();

}
