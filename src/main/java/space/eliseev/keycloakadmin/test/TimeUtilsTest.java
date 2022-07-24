package space.eliseev.keycloakadmin.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import space.eliseev.keycloakadmin.commons.TimeUtils;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilsTest {

    @BeforeAll
    public static void startMethod() {
        System.out.println("to local data time");
        System.out.println("to long");
    }

    @Test
    public void testToLocalDateTime() {
        long time = 1499070360;
        LocalDateTime expResult = LocalDateTime.parse("2017-07-03T11:26");
        LocalDateTime result = TimeUtils.toLocalDateTime(time);
        assertEquals(result, expResult);
    }

    @Test
    public void testToLong() {
        LocalDateTime time = LocalDateTime.parse("2017-07-03T11:26");
        long expResult = 1499070360L;
        long result = TimeUtils.toLong(time);
        assertEquals(result, expResult);
    }


}