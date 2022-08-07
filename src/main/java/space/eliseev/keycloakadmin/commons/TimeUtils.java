package space.eliseev.keycloakadmin.commons;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@UtilityClass
public class TimeUtils {

    public static LocalDateTime toLocalDateTime(@NonNull Long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time),
                TimeZone.getDefault().toZoneId());
    }

    public static Long toLong(@NonNull LocalDateTime localTime) {
        ZonedDateTime zdt = ZonedDateTime.of(localTime, ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

}
