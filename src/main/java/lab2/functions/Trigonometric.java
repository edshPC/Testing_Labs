package lab2.functions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Trigonometric {

    private final SeriesExpansion exp;

    public double sin(double x) {
        return exp.sin(x);
    }

    public double cos(double x) {
        return sin(x + Math.PI / 2);
    }

    public double tan(double x) {
        return sin(x) / cos(x);
    }

    public double cot(double x) {
        return cos(x) / sin(x);
    }

    public double sec(double x) {
        return 1 / cos(x);
    }

}
