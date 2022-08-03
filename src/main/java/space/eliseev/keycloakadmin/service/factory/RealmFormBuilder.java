package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import space.eliseev.keycloakadmin.dto.RealmDto;

import java.util.List;

public interface RealmFormBuilder {
    byte[] download(@NonNull List<RealmDto> realmDto);
}
