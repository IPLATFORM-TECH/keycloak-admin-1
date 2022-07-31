package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;
import space.eliseev.keycloakadmin.service.factory.UserFormBuilderFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormBuilderServiceImpl implements FormBuilderService {

    private final UserFormBuilderFactory userFormBuilderFactory;
    private final UserService userService;

    public List<Client> downloadAllClients() {
        return null;
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

}
