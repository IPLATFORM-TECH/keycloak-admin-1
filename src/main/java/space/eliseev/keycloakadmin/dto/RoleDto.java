package space.eliseev.keycloakadmin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {
    private String clientRealmConstraint;
    private Boolean clientRole;
    private String description;
    private String name;
    private String client;
    private String realm;
}
