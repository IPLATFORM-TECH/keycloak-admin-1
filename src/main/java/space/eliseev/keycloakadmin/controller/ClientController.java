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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.dto.ClientDto;
import space.eliseev.keycloakadmin.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/client", produces = "application/json; charset=UTF-8")
@Tag(name = "Client API", description = "Получение информации о клиентах")
public class ClientController {
    private final ClientService clientService;

    @Operation(summary = "Get all clients",
            description = "Получить список всех клиентов",
            tags = {"Client API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClientDto.class))),
                    description = "Successful operation")
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<ClientDto>> getClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get client by id",
            description = "Получить пользователя по идентификатору",
            tags = {"Client API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClientDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Client not found")
    })
    @GetMapping("/getById/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable @Parameter(description = "client id") String id) {

        final Optional<ClientDto> client = clientService.getById(id);

        return client
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Get client by name",
            description = "Получить пользователя по идентификатору",
            tags = {"Client API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClientDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Client not found")
    })
    @GetMapping("/getByName/{name}")
    public ResponseEntity<ClientDto> getByName(@PathVariable @Parameter(description = "client name") String name) {

        final Optional<ClientDto> client = clientService.getByName(name);

        return client
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
