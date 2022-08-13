package space.eliseev.keycloakadmin.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private String email;
    private String emailConstraint;
    private Boolean emailVerified;
    private Boolean enabled;
    private String firstName;
    private String lastName;
    private String username;
    private LocalDateTime createdTimestamp;
    private Integer notBefore;
    private String realmName;
}
