package space.eliseev.keycloakadmin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "event_entity")
public class Event extends BaseEntity {
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "details_json")
    private String detailsJson;

    @Column(name = "error")
    private String error;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "realm_id")
    private String realmId;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "event_time")
    private Long eventTime;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private String userId;
}
