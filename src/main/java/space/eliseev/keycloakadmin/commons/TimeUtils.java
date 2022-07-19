package space.eliseev.keycloakadmin.commons;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@UtilityClass
public class TimeUtils {

    public LocalDateTime toLocalDateTime(Long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(time),
                TimeZone.getDefault().toZoneId());
    }

    public Long toLong(LocalDateTime localTime) {
        ZonedDateTime zdt = ZonedDateTime.of(localTime, ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

}
