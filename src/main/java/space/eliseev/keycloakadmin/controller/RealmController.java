package space.eliseev.keycloakadmin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.dto.RealmDto;
import space.eliseev.keycloakadmin.service.RealmService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/realm", produces = "application/json; charset=UTF-8")
@Tag(name = "Realm API", description = "Получение информации о realms")
public class RealmController {

    private final RealmService realmService;

    @Operation(
            summary = "Gets all realms",
            description = "Получить список всех realms",
            tags = {"Realm API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RealmDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RealmDto>> getRealms() {
        return new ResponseEntity<>(realmService.getAllRealms(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get realm by ID",
            description = "Получить realm по идентификатору",
            tags = {"Realm API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RealmDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Realm not found")
    })
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<RealmDto> getById(
            @Parameter(
                    required = true,
                    description = "Идентификатор realm")
            @RequestParam String id) {

        final Optional<RealmDto> realm = realmService.getById(id);

        return realm.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Get realm by name",
            description = "Получить realm по имени",
            tags = {"Realm API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RealmDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Realm not found")
    })
    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<RealmDto> getByName (
            @Parameter(
                    required = true,
                    description = "Имя realm")
            @RequestParam String name) {

        final Optional<RealmDto> realm = realmService.getByName(name);

        return realm.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
