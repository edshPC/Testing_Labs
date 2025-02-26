package lab1;

import lab1.model.Body;
import lab1.model.Kilobuzz;
import lab1.model.Person;
import lab1.model.Position;
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
