package space.eliseev.keycloakadmin.service;

import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RealmDto;
import space.eliseev.keycloakadmin.entity.Realm;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Получение информации о области
 */
@Service
public interface RealmService {
    List<RealmDto> getAllRealms();
    Optional<RealmDto> getById(@NotNull String id);
    Optional<RealmDto> getByName(@NotNull String name);

}
