package lab1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Body {
    private int id;
    private Position position;
    private Action action = Action.STANDING;
    private Fingers fingers = new Fingers();

    public Body(int id, Position position) {
        this.id = id;
        this.position = position;
    }

    public void lay() {
        setAction(Action.LAYING);
    }

    public void holdWithFingers(Object object) {
        fingers.hold(object);
    }

    public enum Action {
        STANDING, LAYING
    }

}
