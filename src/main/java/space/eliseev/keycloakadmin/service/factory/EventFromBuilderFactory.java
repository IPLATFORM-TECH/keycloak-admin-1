package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.dto.EventDto;
import space.eliseev.keycloakadmin.service.EventFromBuilderCsv;
import space.eliseev.keycloakadmin.service.EventFromBuilderXlsx;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventFromBuilderFactory {
    private final EventFromBuilderCsv fromBuilderCsv;
    private final EventFromBuilderXlsx fromBuilderXlsx;

    public byte[] download(@NonNull List<EventDto> eventDtoList, @NonNull TypeFile typeFile) {
        return switch (typeFile) {
            case CSV -> fromBuilderCsv.downloadEvent(eventDtoList);
            case XLSX -> fromBuilderXlsx.downloadEvent(eventDtoList);
        };
    }
}
