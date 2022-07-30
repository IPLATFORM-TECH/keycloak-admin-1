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
    @Query(value = "SELECT e FROM Event e join e.user where e.user.username = :username")
    Optional<Event> findByUsername(@Param("username") String username);

    @Query("SELECT e FROM Event e where e.eventTime between  :timeStart and :timeEnd")
    List<Event> findByDate(@Param("timeStart") Long timeStart, @Param("timeEnd") Long timeEnd);

    @Query("SELECT e FROM Event e join e.user where e.user = :username and e.eventTime between :timeStart and :timeEnd")
    List<Event> findByUsernameAndDate(@Param("username") String username, @Param("timeStart") Long timeStart, @Param("timeEnd") Long timeEnd);
}
