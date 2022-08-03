package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;

import java.util.List;

public interface FormBuilderService {

    List<Client> downloadAllClients();

    List<Realm> downloadAllRealm();

    byte[] downloadAllRole(@NonNull TypeFile typeFile);
}
