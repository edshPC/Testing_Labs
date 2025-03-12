package lab2.functions;

public class Logarithmic {

    public static double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("ln(x) определён только для x > 0");
        }
        double epsilon = 1e-15;
        double t = (x - 1) / (x + 1);
        double term = t;
        double sum = 0;
        int n = 1;

        while (Math.abs(term) > epsilon) {
            sum += term / n;
            term *= t * t;
            n += 2;
        }
        return 2 * sum;
    }

    public static double log_2(double x) {
        return ln(x) / ln(2);
    }

    public static double log_5(double x) {
        return ln(x) / ln(5);
    }

    public static double log_10(double x) {
        return ln(x) / ln(10);
    }

}
