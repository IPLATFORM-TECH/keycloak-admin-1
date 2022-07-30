package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.dto.RoleDto;

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
    List<RoleDto> getAllRoles();

    /**
     * Получить роль по идентификатору
     *
     * @param id Идентификатор роли
     * @return роль
     */
    Optional<RoleDto> getById(@NonNull String id);

    /**
     * Получить роль по имени
     *
     * @param name Имя роли
     * @return роль
     */
    Optional<RoleDto> getByName(@NonNull String name);
}