package space.eliseev.keycloakadmin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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

    @Column(name = "user_id", insertable = false, updatable = false)
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Realm realm;
}
