package space.eliseev.keycloakadmin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.dto.RealmDto;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.service.RealmService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/realm", produces = "application/json; charset=UTF-8")
@Tag(name = "Realm", description = "The Realm API")
public class RealmController {

    private final RealmService realmService;

    @GetMapping(value = "/getAll")
    @Operation(summary = "Gets all realms")
    public ResponseEntity<List<RealmDto>> getRealms() {
        return new ResponseEntity<>(realmService.getAllRealms(), HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{id}")
    @Operation(summary = "Gets realm by ID")
    public ResponseEntity<RealmDto> getById(@RequestParam String id) {

        final Optional<RealmDto> realm = realmService.getById(id);

        return realm.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/getByName/{name}")
    @Operation(summary = "Gets realm by Name")
    public ResponseEntity<RealmDto> getByName (@RequestParam String name) {

        final Optional<RealmDto> realm = realmService.getByName(name);

        return realm.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
