package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.eliseev.keycloakadmin.commons.FileType;
import space.eliseev.keycloakadmin.dto.RoleDto;
import space.eliseev.keycloakadmin.service.RoleFormBuilder;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleFormBuilderFactory {

    public final RoleFormBuilder formBuilderXlsx;
    public final RoleFormBuilder formBuilderCsv;

    public byte[] download (@NonNull List<RoleDto> roleDtoList, FileType fileType) {
        return switch (fileType) {
            case XLSX -> formBuilderXlsx.download(roleDtoList);
            case CSV -> formBuilderCsv.download(roleDtoList);
            default -> throw new IllegalArgumentException("Неверный формат данных");
        };
    }
}
