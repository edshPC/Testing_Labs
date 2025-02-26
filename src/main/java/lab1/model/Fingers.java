package lab1.model;

import lombok.Data;

@Data
public class Fingers {
    private Object holding;

    public void hold(Object object) {
        setHolding(object);
    }

}
