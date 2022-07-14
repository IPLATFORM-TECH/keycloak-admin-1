package space.eliseev.keycloakadmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/client", produces = "application/json; charset=UTF-8")
public class ClientController {
    private final ClientService clientService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Client> getById(@PathVariable String id) {

        final Optional<Client> client = clientService.getById(id);

        return client
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Client> getByName(@PathVariable String name) {

        final Optional<Client> client = clientService.getByName(name);

        return client
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
