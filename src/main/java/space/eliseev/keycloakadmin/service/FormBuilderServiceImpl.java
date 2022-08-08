package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;
import space.eliseev.keycloakadmin.service.factory.ClientFormBuilderFactory;
import space.eliseev.keycloakadmin.service.factory.EventFromBuilderFactory;
import space.eliseev.keycloakadmin.service.factory.UserFormBuilderFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormBuilderServiceImpl implements FormBuilderService {

    private final UserFormBuilderFactory userFormBuilderFactory;
    private final ClientFormBuilderFactory clientFormBuilderFactory;
    private final UserService userService;
    private final ClientService clientService;
    private final EventFromBuilderFactory eventFromBuilderFactory;
    private final EventService eventService;

    public byte[] downloadAllClients(@NonNull TypeFile typeFile) {
        return clientFormBuilderFactory.download(clientService.getAllClients(), typeFile);
    }

    public List<Realm> downloadAllRealm() {
        return null;
    }

    public List<Role> downloadAllRole() {
        return null;
    }

    @Override
    public byte[] downloadAllUsers(@NonNull TypeFile typeFile) {
        return userFormBuilderFactory.download(userService.getAllUsers(), typeFile);
    }

    @Override
    public byte[] downloadAllEvent(@NonNull TypeFile typeFile) {
        return eventFromBuilderFactory.download(eventService.getAllEvents(), typeFile);
    }
}
