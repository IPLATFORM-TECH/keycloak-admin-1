package space.eliseev.keycloakadmin.service;

import lombok.NonNull;
import space.eliseev.keycloakadmin.entity.User;

import java.util.List;

public interface UserFormBuilder {

    byte[] download(@NonNull List<User> users);

}
