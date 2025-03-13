package lab2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Logarithmic {

    private final SeriesExpansion exp;

    public double ln(double x) {
        return exp.ln(x);
    }

    public double log_2(double x) {
        return ln(x) / ln(2);
    }

    public double log_5(double x) {
        return ln(x) / ln(5);
    }

    public double log_10(double x) {
        return ln(x) / ln(10);
    }

}
