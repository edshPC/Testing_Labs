package lab2.functions;

public class SeriesExpansion {

    static final double epsilon = 1e-15;

    public double sin(double x) {
        x = x % (2 * Math.PI);
        if (x > Math.PI) {
            x -= 2 * Math.PI;
        } else if (x < -Math.PI) {
            x += 2 * Math.PI;
        }

        double term = x;
        double sum = x;
        int n = 1;
        while (Math.abs(term) > epsilon && n < 1000000) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            sum += term;
            n++;
        }
        return sum;
    }

    public double ln(double x) {
        if (x <= 0) {
            throw new ArithmeticException("ln(x) определён только для x > 0");
        }

        double t = (x - 1) / (x + 1);
        double term = t;
        double sum = 0;
        int n = 1;
        while (Math.abs(term) > epsilon && n < 1000000) {
            sum += term / n;
            term *= t * t;
            n += 2;
        }
        return 2 * sum;
    }

}
