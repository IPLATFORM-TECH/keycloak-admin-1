package space.eliseev.keycloakadmin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.RealmDto;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.mapper.RealmMapper;
import space.eliseev.keycloakadmin.repository.RealmRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Реализация {@link RealmService}
 */

@Service
@RequiredArgsConstructor
public class RealmServiceImpl implements RealmService {

    private final RealmRepository realmRepository;
    private final RealmMapper mapper;

    @Override
    public List<RealmDto> getAllRealms() {
        return realmRepository.findAll()
                .stream()
                .map(mapper::modelToDto)
                .toList();
    }

    @Override
    public Optional<RealmDto> getById(@NotNull String id) {
        return realmRepository.findById(id)
                .map(mapper::modelToDto);
    }

    @Override
    public Optional<RealmDto> getByName(@NotNull String name) {
        return realmRepository.findByName(name)
                .map(mapper::modelToDto);
    }
}
