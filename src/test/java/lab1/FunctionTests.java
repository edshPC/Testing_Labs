package lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FunctionTests {
    private static final double DELTA = 1e-6;
    private static final Random rand = new Random();

    @Test
    void arctgTest() {
        for (double i = -Math.PI/2; i <= Math.PI/2; i += 1e-4) {
            double x = Math.tan(i);
            Assertions.assertEquals(
                    Functions.arctg(x),
                    Math.atan(x),
                    DELTA
            );
        }
    }

    @Test
    void sortTest() {
        final int size = 1000;
        for (int i = 0; i < 10; i++) {
            List<Double> list = new ArrayList<>(size);
            for (int j = 0; j < size; j++) list.add(rand.nextDouble());
            List<Double> expectedList = new ArrayList<>(list);
            Functions.bubbleSort(list);
            Collections.sort(expectedList);
            Assertions.assertEquals(expectedList, list);
        }
    }
}
