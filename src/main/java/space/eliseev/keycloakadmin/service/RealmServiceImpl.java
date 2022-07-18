package space.eliseev.keycloakadmin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.entity.Realm;
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

    @Override
    public List<Realm> getAllRealms() {
        return realmRepository.findAll();
    }

    @Override
    public Optional<Realm> getById(@NotNull String id) {
        return realmRepository.findById(id);
    }

    @Override
    public Optional<Realm> getByName(@NotNull String name) {
        return realmRepository.findByName(name);
    }
}
