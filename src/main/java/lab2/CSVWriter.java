package lab2;

import lombok.SneakyThrows;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class CSVWriter {

    @SneakyThrows
    public static void generate(String filename, double from, double to, double step, Function<Double, Double> f) {
        Path path = Path.of(filename);
        Files.createDirectories(path.getParent());
        Files.deleteIfExists(path);
        try (FileWriter fw = new FileWriter(path.toFile())) {
            for (double x = from; x <= to; x += step) {
                fw.write(x + "," + f.apply(x) + "\n");
            }
        }
    }

    public static void main(String[] args) {
        var exp = new SeriesExpansion();
        var tr = new Trigonometric(exp);
        var lg = new Logarithmic(exp);
        var system = new FuncSystem(tr, lg);

        generate("target/sin.csv", -10, 10, .1, tr::sin);
        generate("target/cos.csv", -10, 10, .1, tr::cos);
        generate("target/tan.csv", -10, 10, .1, tr::tan);
        generate("target/cot.csv", -10.05, 10, .1, tr::cot);
        generate("target/sec.csv", -10, 10, .1, tr::sec);

        generate("target/ln.csv", .1, 20, .1, lg::ln);
        generate("target/log_2.csv", .1, 20, .1, lg::log_2);
        generate("target/log_5.csv", .1, 20, .1, lg::log_5);
        generate("target/log_10.csv", .1, 20, .1, lg::log_10);

        generate("target/system.csv", -10.12, 10, .1, system::system);
    }

}
