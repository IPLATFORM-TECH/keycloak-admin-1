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
import space.eliseev.keycloakadmin.dto.EventDto;
import space.eliseev.keycloakadmin.service.EventService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/event", produces = "application/json; charset=UTF-8")
@Tag(name = "Event API", description = "Получение информации о событиях")
public class EventController {

    private final EventService eventService;

    @Operation(
            summary = "Get all events",
            description = "Получить список всех событий",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation")
    })
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<EventDto>> getEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get event by ID",
            description = "Получить событие по идентификатору",
            tags = {"Event API"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventDto.class))),
                    description = "Successful operation"),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content,
                    description = "Event not found")
    })
    @GetMapping(value = "/getById/id={id}")
    public ResponseEntity<EventDto> getById(
            @Parameter(
                    required = true,
                    description = "Идентификатор событий")
            @PathVariable String id) {

        final Optional<EventDto> event = eventService.getById(id);

        return event
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Gets event by username")
    @GetMapping(value = "/getByUsername/username={username}")
    public ResponseEntity<EventDto> getByUsername(@PathVariable String username) {
        final Optional<EventDto> event = eventService.getByUsername(username);

        return event
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Gets event by date")
    @GetMapping(value = "/getByDate/startDate={localDateTimeStart:-*}&endDate={localDateTimeEnd:-*}")
    public ResponseEntity<List<EventDto>> getByDate(@PathVariable LocalDateTime localDateTimeStart, @PathVariable LocalDateTime localDateTimeEnd) {
        final List<EventDto> event = eventService.getByDate(localDateTimeStart, localDateTimeEnd);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @Operation(summary = "Gets event by username and date")
    @GetMapping(value = "/getAllBy/username={username}&startDate={localDateTimeStart:_*}&endDate={localDateTimeEnd:_*}")
    public ResponseEntity<List<EventDto>> getByUsernameAndDate(@PathVariable String username, @PathVariable LocalDateTime localDateTimeStart, @PathVariable LocalDateTime localDateTimeEnd) {
        final List<EventDto> event = eventService.getByUsernameAndDte(username, localDateTimeStart, localDateTimeEnd);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

}
