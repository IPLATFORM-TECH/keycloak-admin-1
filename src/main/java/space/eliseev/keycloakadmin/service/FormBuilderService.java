package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;

import java.util.List;

public interface FormBuilderService {

    byte[] downloadAllClients(@NonNull TypeFile typeFile);

    List<Realm> downloadAllRealm();

    List<Role> downloadAllRole();

    byte[] downloadAllUsers(@NonNull TypeFile typeFile);

}
