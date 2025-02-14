package lab1;

import java.util.List;

public class Functions {

    public static double arctg(double x) {
        if (x < 0) return -arctg(-x);
        if (x > 1) return Math.PI / 2 - arctg(1 / x);

        double epsilon = 1e-15;
        double sum = 0;
        double term = x;
        double xSquared = -x * x;
        int n = 0;

        while (Math.abs(term) > epsilon && n < 1000000) {
            sum += term;
            term *= xSquared * (2 * n + 1) / (2 * n + 3);
            n++;
        }
        return sum;
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

}
