/*
 * Copyright (c) 2022 Aleksandr Eliseev
 *
 * This source code is Aleksandr Eliseev's Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

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
import space.eliseev.keycloakadmin.dto.UserDto;
import space.eliseev.keycloakadmin.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Получение информации о пользователях
 *
 * @author <a href="mailto:a.s.eliseev@yandex.ru">Aleksandr Eliseev</a>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user", produces = "application/json; charset=UTF-8")
@Tag(name = "User API", description = "Получение информации о пользователях")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Get all users",
            description = "Получить список всех пользователей",
            tags = {"User API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get user by ID",
            description = "Получить пользователя по идентификатору",
            tags = {"User API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class))),
                                       description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "User not found")
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getById(
            @Parameter(
                    required = true,
                    description = "Идентификатор пользователя")
            @PathVariable String id) {

        final Optional<UserDto> user = userService.getById(id);

        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Get user by username",
            description = "Получить пользователя имени",
            tags = {"User API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "User not found")
    })
    @GetMapping(value = "/getByUsername/username={username}")
    public ResponseEntity<List<UserDto>> getByUsername(@PathVariable String username) {
        final List<UserDto> user = userService.getByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(
            summary = "Get all users",
            description = "Получить список пользователей по Email",
            tags = {"User API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getByEmail/email={email}")
    public ResponseEntity<List<UserDto>> getByEmail(@PathVariable String email) {
        final List<UserDto> user = userService.getByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get user by email and realmName",
            description = "Получить пользователя по Email и realmName",
            tags = {"User API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "User not found")
    })
    @GetMapping("/getByEmailAndRealmName/email={email}&realmName={realmName}")
    public ResponseEntity<UserDto> getByEmailAndRealmName(
            @Parameter(
                    required = true,
                    description = "email и realmName пользователя")
            @PathVariable String email, @PathVariable String realmName) {

        final Optional<UserDto> user = userService.getByEmailAndRealmName(email, realmName);

        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

