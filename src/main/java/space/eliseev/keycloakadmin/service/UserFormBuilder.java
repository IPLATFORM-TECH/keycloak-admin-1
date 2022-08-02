package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.dto.UserDto;

import java.util.List;

public interface UserFormBuilder {

    byte[] download(@NonNull List<UserDto> users);

}
