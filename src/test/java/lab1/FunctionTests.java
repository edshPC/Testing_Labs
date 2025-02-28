package lab1;

import lab1.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.DoubleStream;

public class FunctionTests {
    private static final double DELTA = 1e-6;
    private static final Random rand = new Random();

    @ParameterizedTest
    @MethodSource
    @ValueSource(doubles = {0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void arctgTest(double x) {
        Assertions.assertEquals(
                Functions.arctg(x),
                Math.atan(x),
                DELTA
        );
    }

    static DoubleStream arctgTest() {
        var builder = DoubleStream.builder();
        for (double i = -Math.PI / 2; i <= Math.PI / 2; i += 1e-3) {
            double x = Math.tan(i);
            builder.add(x);
        }
        return builder.build();
    }

    @Test
    void sortTest() {
        final int size = 1000;
        for (int i = 0; i < 100; i++) {
            List<Double> list = new ArrayList<>(size);
            for (int j = 0; j < size; j++) list.add(rand.nextDouble());
            List<Double> expectedList = new ArrayList<>(list);
            Functions.bubbleSort(list);
            Collections.sort(expectedList);
            Assertions.assertEquals(expectedList, list);
        }
    }

    @Test
    void modelTest() {
        for (int i = 0; i < 100; i++) {
            var person = new Person( // он
                    rand.nextInt(10, 1000),
                    new Position(rand.nextInt(), rand.nextInt()));
            var body = new Body(1, // первое тело
                    new Position(rand.nextInt(), rand.nextInt()));
            var kilobuzz = new Kilobuzz(); // килобац

            person.walkTo(body); // он подошел к первому телу
            Assertions.assertEquals(person.getPosition(), body.getPosition());

            body.lay(); // Оно лежало
            Assertions.assertEquals(body.getAction(), Body.Action.LAYING);
            Assertions.assertEquals(person.getAction(), Body.Action.STANDING);

            body.holdWithFingers(kilobuzz); //  килобац, который оно сжимало пальцами
            Assertions.assertEquals(body.getFingers().getHolding(), kilobuzz);

            person.putFootOn(kilobuzz); // поставил ногу на килобац
            Assertions.assertEquals(person.getFootOn(), kilobuzz);
            Assertions.assertEquals(person.getFootOn(), body.getFingers().getHolding());
            Assertions.assertEquals(body.getAction(), Body.Action.LAYING); // продолжало лежать так
        }
    }

}
