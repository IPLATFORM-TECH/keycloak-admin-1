package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RoleDto;
import space.eliseev.keycloakadmin.mapper.RoleMapper;
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
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map(roleMapper::modelToDto).toList();
    }

    @Override
    public Optional<RoleDto> getById(@NonNull String id) {
        return roleRepository.findById(id).map(roleMapper::modelToDto);
    }

    @Override
    public Optional<RoleDto> getByName(@NonNull String name) {
        return roleRepository.findByName(name).map(roleMapper::modelToDto);
    }
}
