package space.eliseev.keycloakadmin.service;

import space.eliseev.keycloakadmin.entity.Realm;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Получение информации о области
 */
public interface RealmService {
    List<Realm> getAllRealms();
    Optional<Realm> getById(@NotNull String id);
    Optional<Realm> getByName(@NotNull String name);

}
