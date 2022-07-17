package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Role;
import space.eliseev.keycloakadmin.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

/**
 * Реализация {@link RoleService}
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getById(@NonNull String id) {
        return roleRepository.findById(id);
    }

    @Override
    public Optional<Role> getByName(@NonNull String name) {
        return roleRepository.findByName(name);
    }
}
