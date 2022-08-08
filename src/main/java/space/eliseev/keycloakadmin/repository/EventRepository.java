package space.eliseev.keycloakadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import space.eliseev.keycloakadmin.entity.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    @Query("select T2.name from Event T1 join Realm T2 on T2.id = T1.realmId")
    String findByRealmId();
    @Query("select T2.username from Event T1 join User T2 on T2.id = T1.userId")
    String findByUserId();
    @Query("select T2.name from Event T1 join Client T2 on T2.clientId = T1.clientId")
    String findByClientId();
    @Query(value = "SELECT e FROM Event e join e.user where e.user.username = :username")
    Optional<Event> findByUsername(@Param("username") String username);

    @Query("SELECT e FROM Event e where e.eventTime between  :timeStart and :timeEnd")
    List<Event> findByDate(@Param("timeStart") Long timeStart, @Param("timeEnd") Long timeEnd);

    @Query("SELECT e FROM Event e join e.user where e.user = :username and e.eventTime between :timeStart and :timeEnd")
    List<Event> findByUsernameAndDate(@Param("username") String username, @Param("timeStart") Long timeStart, @Param("timeEnd") Long timeEnd);
}
