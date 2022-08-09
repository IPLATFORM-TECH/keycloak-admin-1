package space.eliseev.keycloakadmin.service;

import liquibase.repackaged.com.opencsv.CSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.eliseev.keycloakadmin.dto.EventDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventFromBuilderCsv implements EventFromBuilder {
    private final EventDataService eventDataService;

    @Override
    public byte[] downloadEvent(@NonNull List<EventDto> eventDtoList) {
        byte[] eventArr = null;

        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
             CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream))) {

            String[] columns = new String[]{"clientId", "detailsJson", "error", "ip_address", "realm_id", "event_time", "type", "user_id"};

            writer.writeNext(columns);

            String[] data;
            for (EventDto eventDto : eventDtoList) {
                data = new String[]{
                        String.valueOf(eventDataService.getClientName()),
                        eventDto.getDetailsJson(),
                        eventDto.getError(),
                        eventDto.getIpAddress(),
                        String.valueOf(eventDataService.getRealmName()),
                        String.valueOf(eventDto.getEventTime()),
                        eventDto.getType(),
                        String.valueOf(eventDataService.getUsername())};
                writer.writeNext(data);
            }
            writer.flush();
            eventArr = stream.toByteArray();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return eventArr;
    }
}
