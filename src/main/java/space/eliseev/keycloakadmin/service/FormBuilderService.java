package space.eliseev.keycloakadmin.service;

import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;
import space.eliseev.keycloakadmin.service.factory.FileType;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface FormBuilderService {

    List<Client> downloadAllClients();

    byte[] downloadAllRealms(@NotNull FileType fileType);

    List<Role> downloadAllRole();

}
