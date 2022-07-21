package space.eliseev.keycloakadmin.commons;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

class TimeUtilsTest {

    @Test
    public void toLocalDateTime() {
        long time = 1499070360L;
        LocalDateTime local = LocalDateTime.ofInstant(Instant.ofEpochSecond(time),
                TimeZone.getDefault().toZoneId());
        System.out.println(local);

    }

    @Test
    public void toLong() {
        LocalDateTime time_local = LocalDateTime.parse("2017-07-03T11:26");

        ZonedDateTime zdt = ZonedDateTime.of(time_local, ZoneId.systemDefault());
        long date = zdt.toInstant().toEpochMilli() / 1000;
        System.out.println(date);
    }
}