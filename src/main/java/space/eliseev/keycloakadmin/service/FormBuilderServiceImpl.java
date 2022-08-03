package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.service.factory.RoleFormBuilderFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormBuilderServiceImpl implements FormBuilderService {

    private final RoleFormBuilderFactory roleFormBuilderFactory;
    private final RoleService roleService;

    public List<Client> downloadAllClients() {
        return null;
    }

    public List<Realm> downloadAllRealm() {
        return null;
    }

    @Override
    public byte[] downloadAllRole(@NonNull TypeFile typeFile) {
        return roleFormBuilderFactory.download(roleService.getAllRoles(), typeFile);
    }

}
