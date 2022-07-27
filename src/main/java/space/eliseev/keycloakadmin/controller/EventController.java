package space.eliseev.keycloakadmin.controller;

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
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<EventDto>> getEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping(value = "/getById/id={id}")
    public ResponseEntity<EventDto> getById(@PathVariable String id) {
        final Optional<EventDto> event = eventService.getById(id);

        return event
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/getByUsername/username={username}")
    public ResponseEntity<EventDto> getByUsername(@PathVariable String username) {
        final Optional<EventDto> event = eventService.getByUsername(username);

        return event
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/getByDate/startDate={localDateTimeStart:-*}&endDate={localDateTimeEnd:-*}")
    public ResponseEntity<List<EventDto>> getByDate(@PathVariable LocalDateTime localDateTimeStart, @PathVariable LocalDateTime localDateTimeEnd) {
        final List<EventDto> event = eventService.getByDate(localDateTimeStart, localDateTimeEnd);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllBy/username={username}&startDate={localDateTimeStart:_*}&endDate={localDateTimeEnd:_*}")
    public ResponseEntity<List<EventDto>> getByUsernameAndDate(@PathVariable String username, @PathVariable LocalDateTime localDateTimeStart, @PathVariable LocalDateTime localDateTimeEnd) {
        final List<EventDto> event = eventService.getByUsernameAndDte(username, localDateTimeStart, localDateTimeEnd);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

}
