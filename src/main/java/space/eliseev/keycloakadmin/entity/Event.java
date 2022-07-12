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
public class Event extends BaseEntity{
    @Column(name = "client_id")
    private String client_id;

    @Column(name = "details_json")
    private String details_json;

    @Column(name = "error")
    private String error;

    @Column(name = "ip_address")
    private  String ip_address;

    @Column(name = "realm_id")
    private String realm_id;

    @Column(name = "session_id")
    private String session_id;

    @Column(name = "event_time")
    private Long event_time;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private String user_id;
}
