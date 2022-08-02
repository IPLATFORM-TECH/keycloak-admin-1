package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.eliseev.keycloakadmin.commons.FileType;
import space.eliseev.keycloakadmin.dto.RoleDto;
import space.eliseev.keycloakadmin.service.RoleFormBuilder;
import space.eliseev.keycloakadmin.service.RoleFormBuilderCsv;
import space.eliseev.keycloakadmin.service.RoleFormBuilderXlsx;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleFormBuilderFactory {

    public final RoleFormBuilderXlsx formBuilderXlsx;
    public final RoleFormBuilderCsv formBuilderCsv;

    public byte[] download (@NonNull List<RoleDto> roleDtoList, FileType fileType) {
        return switch (fileType) {
            case XLSX -> formBuilderXlsx.download(roleDtoList);
            case CSV -> formBuilderCsv.download(roleDtoList);
            default -> throw new IllegalArgumentException("Неверный формат данных");
        };
    }
}
