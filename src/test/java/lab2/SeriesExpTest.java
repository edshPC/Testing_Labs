package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesExpTest {

    static final double DELTA = 1e-6;

    @Test
    void test() {
        var exp = new SeriesExpansion();
        for (double i = -100; i < 100; i+=.01) {
            assertEquals(exp.sin(i), Math.sin(i), DELTA);
        }
        for (double i = .01; i < 100; i+=.01) {
            assertEquals(exp.ln(i), Math.log(i), DELTA);
        }
    }

}
