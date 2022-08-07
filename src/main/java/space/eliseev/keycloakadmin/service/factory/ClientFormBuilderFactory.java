package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.eliseev.keycloakadmin.service.ClientFormBuilderCsv;
import space.eliseev.keycloakadmin.service.ClientFormBuilderXlsx;
import space.eliseev.keycloakadmin.dto.ClientDto;
import space.eliseev.keycloakadmin.commons.TypeFile;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientFormBuilderFactory {
    public final ClientFormBuilderXlsx formBuilderXlsx;
    public final ClientFormBuilderCsv formBuilderCsv;

    public byte[] download(@NonNull List<ClientDto> clients, @NonNull TypeFile fileType) {
        return switch (fileType) {
            case XLSX -> formBuilderXlsx.download(clients);
            case CSV -> formBuilderCsv.download(clients);
        };
    }
}
