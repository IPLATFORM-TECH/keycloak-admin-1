package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.ClientDto;
import space.eliseev.keycloakadmin.mapper.ClientMapper;
import space.eliseev.keycloakadmin.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::toDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientDto> getById(@NonNull String id) {
        return Optional.ofNullable(mapper.toDtoMapper(clientRepository.findById(id).get()));
    }

    @Override
    public Optional<ClientDto> getByName(String name) {
        return Optional.ofNullable(mapper.toDtoMapper(clientRepository.findByName(name).get()));
    }
}
