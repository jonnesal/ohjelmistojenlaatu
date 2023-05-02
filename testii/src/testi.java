import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testi {

    @ParameterizedTest(name="Testi {index}: Sekuntit {0} -> Aika {1}")
    @CsvSource({ "0, 0:00:00", "65, 0:01:05", "3605, 1:00:05", "3665, 1:01:05",
    	"-1, -1"})
    public void testSecToTime(int a, String expected) {
        String result = TimeUtils.secToTime(a);
        assertEquals(expected, result);
    }
}
