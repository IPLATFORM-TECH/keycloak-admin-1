package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.entity.Role;
import space.eliseev.keycloakadmin.service.factory.FileType;
import space.eliseev.keycloakadmin.service.factory.RealmFormBuilderFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormBuilderServiceImpl implements FormBuilderService {

    private final RealmFormBuilderFactory realmFormBuilderFactory;

    private final RealmService realmService;
    public List<Client> downloadAllClients() {
        return null;
    }

    @Override
    public byte[] downloadAllRealms(@NonNull FileType fileType) {
        return realmFormBuilderFactory.download(realmService.getAllRealms(), fileType);
    }


    public List<Role> downloadAllRole() {
        return null;
    }



}
