package space.eliseev.keycloakadmin.commons;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {

    @Test
    public void testToLocalDateTime() {
        System.out.println("to local data time");
        long time = 1499070360;
        LocalDateTime expResult = LocalDateTime.parse("2017-07-03T11:26");
        LocalDateTime result = TimeUtils.toLocalDateTime(time);
        assertEquals(result, expResult);
    }

    @Test
    public void testToLong() {
        System.out.println("to long");
        LocalDateTime time = LocalDateTime.parse("2017-07-03T11:26");
        long expResult = 1499070360L;
        long result = TimeUtils.toLong(time);
        assertEquals(result, expResult);
    }


}