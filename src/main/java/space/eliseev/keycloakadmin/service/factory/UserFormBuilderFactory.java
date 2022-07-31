package space.eliseev.keycloakadmin.service.factory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.User;
import space.eliseev.keycloakadmin.service.UserFormBuilderCsv;
import space.eliseev.keycloakadmin.service.UserFormBuilderXlsx;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFormBuilderFactory {

    public final UserFormBuilderXlsx formBuilderXlsx;
    public final UserFormBuilderCsv formBuilderCsv;

    public byte[] download(@NonNull List<User> users, @NonNull TypeFile fileType) {
        return switch (fileType) {
            case XLSX -> formBuilderXlsx.download(users);
            case CSV -> formBuilderCsv.download(users);
        };
    }

}
