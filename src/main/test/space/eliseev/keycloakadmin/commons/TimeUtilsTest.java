package space.eliseev.keycloakadmin.commons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TimeUtilsTest {
    private static long time;
    private static long time2;
    private static LocalDateTime localDateTime;
    private static LocalDateTime localDateTime2;


    @BeforeAll
    static void startMethod() {
        time = 1499070360;
        time2 = 1593769560;
        localDateTime = LocalDateTime.parse("2017-07-03T11:26");
        localDateTime2 = LocalDateTime.parse("2020-07-03T12:46");
    }

    @Test
    void testToLocalDateTime() {

        assertEquals(TimeUtils.toLocalDateTime(time), localDateTime);
        assertNotEquals(TimeUtils.toLocalDateTime(time), localDateTime2);
        assertEquals(TimeUtils.toLocalDateTime(time2), localDateTime2);
        assertNotEquals(TimeUtils.toLocalDateTime(time2), localDateTime);
    }

    @Test
    void testToLong() {
        assertEquals(TimeUtils.toLong(localDateTime), time);
        assertEquals(TimeUtils.toLong(localDateTime2), time2);
        assertNotEquals(TimeUtils.toLong(localDateTime), time2);
        assertNotEquals(TimeUtils.toLong(localDateTime2), time);
    }
}