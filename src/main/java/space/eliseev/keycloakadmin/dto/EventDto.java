package space.eliseev.keycloakadmin.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDto {
    private String clientId;

    private String detailsJson;

    private String error;

    private String ipAddress;

    private String realmId;

    private String sessionId;

    private LocalDateTime eventTime;

    private String type;

    private String userId;
}
