package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Realm;

import java.util.List;

public interface FormBuilderService {

    byte[] downloadAllClients(@NonNull TypeFile typeFile);

    List<Realm> downloadAllRealm();

    byte[] downloadAllRole(@NonNull TypeFile typeFile);

    byte[] downloadAllUsers(@NonNull TypeFile typeFile);

    byte[] downloadAllEvent(@NonNull TypeFile typeFile);

}
