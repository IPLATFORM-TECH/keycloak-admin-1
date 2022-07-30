package space.eliseev.keycloakadmin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormBuilderServiceImpl implements FormBuilderService {

    public List<Client> downloadAllClients() {
        return null;
    }

    public List<Realm> downloadAllRealm() {
        return null;
    }

    public List<Role> downloadAllRole() {
        return null;
    }

}
