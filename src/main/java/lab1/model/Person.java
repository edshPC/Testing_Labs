package lab1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends Body {
    private Object footOn = null;

    public Person(int id, Position position) {
        super(id, position);
    }

    public void walkTo(Position position) {
        setPosition(position);
    }

    public void walkTo(Body body) {
        walkTo(body.getPosition());
    }

    public void putFootOn(Object object) {
        setFootOn(object);
    }

}
