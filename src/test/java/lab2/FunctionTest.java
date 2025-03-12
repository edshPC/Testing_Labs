package lab2;

import lab2.functions.Logarithmic;
import lab2.functions.Trigonometric;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionTest {

    @Test
    void test() {
        for (double i = -100; i < 100; i+=.1) {
            Assertions.assertEquals(Trigonometric.sin(i), Math.sin(i), 1e-5);
            Assertions.assertEquals(Trigonometric.cos(i), Math.cos(i), 1e-5);
        }
        for (double i = .1; i < 100; i+=.1) {
            Assertions.assertEquals(Logarithmic.ln(i), Math.log(i), 1e-5);
        }
    }

}
