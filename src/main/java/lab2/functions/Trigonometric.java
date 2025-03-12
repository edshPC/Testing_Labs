package lab2.functions;

public class Trigonometric {

    public static double sin(double x) {
        x = x % (2 * Math.PI);
        if (x > Math.PI) {
            x -= 2 * Math.PI;
        } else if (x < -Math.PI) {
            x += 2 * Math.PI;
        }

        double epsilon = 1e-15;
        double term = x;
        double sum = x;
        int n = 1;
        while (Math.abs(term) > epsilon) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }

    public static double cos(double x) {
        return sin(x + Math.PI / 2);
    }

    public static double tan(double x) {
        return sin(x) / cos(x);
    }

    public static double cot(double x) {
        return cos(x) / sin(x);
    }

    public static double sec(double x) {
        return 1 / cos(x);
    }

}
