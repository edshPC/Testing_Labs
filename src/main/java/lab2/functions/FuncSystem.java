package lab2.functions;

import static lab2.functions.Trigonometric.*;
import static lab2.functions.Logarithmic.*;

public class FuncSystem {

    public static double system(double x) {
        if (x <= 0) {
            return ((((sec(x) + sec(x)) + tan(x)) + Math.pow(cot(x), 2))
                     - ((cos(x) - sin(x)) * cos(x))) - cos(x);
        } else {
            return Math.pow((((ln(x) / log_5(x)) - log_2(x)) * log_10(x))
                     * log_10(x), 2) / (log_5(x) + ln(x));
        }
    }

}
