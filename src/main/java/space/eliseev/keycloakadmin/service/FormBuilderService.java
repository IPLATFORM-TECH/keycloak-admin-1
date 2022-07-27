package space.eliseev.keycloakadmin.service;

import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;

import java.util.List;

public interface FormBuilderService {

    List<Client> downloadAllClients();

    List<Realm> downloadAllRealm();

    List<Role> downloadAllRole();

}
