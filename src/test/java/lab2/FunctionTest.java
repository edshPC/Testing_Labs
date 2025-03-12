package lab2;

import lab2.functions.Logarithmic;
import lab2.functions.SeriesExpansion;
import lab2.functions.Trigonometric;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionTest {

    @Test
    void test() {
        var exp = new SeriesExpansion();
        var tr = new Trigonometric(exp);
        var lg = new Logarithmic(exp);
        for (double i = -100; i < 100; i+=.01) {
            Assertions.assertEquals(tr.sin(i), Math.sin(i), 1e-5);
        }
        for (double i = .1; i < 100; i+=.01) {
            Assertions.assertEquals(lg.ln(i), Math.log(i), 1e-5);
        }
    }

}
