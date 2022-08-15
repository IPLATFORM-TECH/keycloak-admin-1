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
import space.eliseev.keycloakadmin.dto.RoleDto;
import space.eliseev.keycloakadmin.service.RoleService;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о ролях
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/role", produces = "application/json; charset=UTF-8")
@Tag(name = "Роли", description = "API ролей")
public class RoleController {

    private final RoleService roleService;

    @Operation(
            summary = "Get all roles",
            description = "Получить список всех ролей",
            tags = {"Role API"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RoleDto.class))

                    ),
                    description = "Successful operation"
            )
    })
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RoleDto>> getAll() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get role by ID",
            description = "Получить роль по идентификатору",
            tags = {"Role API"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RoleDto.class))
                    ),
                    description = "Successful operation"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Role not found"
            )
    })
    @GetMapping("/getById/{id}")
    public ResponseEntity<RoleDto> getById(@Parameter(description = "ID роли, которую нужно показать")
                                           @PathVariable String id) {

        final Optional<RoleDto> role = roleService.getById(id);

        return role
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Get role by name",
            description = "Получить роль по названию роли",
            tags = {"Role API"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RoleDto.class))
                    ),
                    description = "Successful operation"
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Role not found"
            )
    })
    @GetMapping("/getByName/{name}")
    public ResponseEntity<RoleDto> getByName(@Parameter(description = "Название роли, которую нужно показать")
                                             @PathVariable String name) {

        final Optional<RoleDto> role = roleService.getByName(name);

        return role
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
