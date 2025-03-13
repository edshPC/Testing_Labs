package lab2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FuncSystem {

    private final Trigonometric tr;
    private final Logarithmic lg;

    public double f1(double x) {
        return ((((tr.sec(x) + tr.sec(x)) + tr.tan(x)) + Math.pow(tr.cot(x), 2))
                - ((tr.cos(x) - tr.sin(x)) * tr.cos(x))) - tr.cos(x);
    }

    public double f2(double x) {
        return Math.pow((((lg.ln(x) / lg.log_5(x)) - lg.log_2(x)) * lg.log_10(x))
                        * lg.log_10(x), 2) / (lg.log_5(x) + lg.ln(x));
    }

    public double system(double x) {
        if (x <= 0) return f1(x);
        else return f2(x);
    }

}
