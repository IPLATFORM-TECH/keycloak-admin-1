package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.eliseev.keycloakadmin.dto.RealmDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RealmFormBuilderFactory {
    private final RealmFormBuilder formBuilderXlsx;
    private final RealmFormBuilder formBuilderCsv;


    public byte[] download (@NonNull List<RealmDto> realmDto,@NonNull FileType fileType){
        return switch (fileType){
            case XLSX -> formBuilderXlsx.download(realmDto);
            case CSV -> formBuilderCsv.download(realmDto);
        };
    }
}
