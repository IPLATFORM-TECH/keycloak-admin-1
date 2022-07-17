package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о ролях
 */
public interface RoleService {

    /**
     * Получить список всех ролей
     *
     * @return список всех ролей
     */
    List<Role> getAllRoles();

    /**
     * Получить роль по идентификатору
     *
     * @param id Идентификатор роли
     * @return роль
     */
    Optional<Role> getById(@NonNull String id);

    /**
     * Получить роль по имени
     *
     * @param name Имя роли
     * @return роль
     */
    Optional<Role> getByName(@NonNull String name);
}