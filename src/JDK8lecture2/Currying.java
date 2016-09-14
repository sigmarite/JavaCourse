package JDK8lecture2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mpividori on 14/09/2016.
 */
public class Currying {

    public static void main(String[] args) {
        BiFunction<Double, Double, Double> logWithBase = (x, b) -> Math.log(x)/Math.log(b);
        Function<Double, Function<Double, Double>> logBase = b -> x -> logWithBase.apply(x, b);

        Function<Double, Double> log10 = logBase.apply(10.);
        Function<Double, Double> log2 = logBase.apply(2.);
        Function<Double, Double> log16 = logBase.apply(16.);

        List<Double> l1 = new ArrayList<>( Arrays.asList(0.5, 1., 2., 5., 10., 16., 25., 64., 100., 1000., 10000.));

        System.out.println("\nlog10");
        System.out.println(l1.stream().map(log10).map(Object::toString).collect(Collectors.joining("\n")));

        System.out.println("\nlog2");
        System.out.println(l1.stream().map(log2).map(Object::toString).collect(Collectors.joining("\n")));

        System.out.println("\nlog16");
        System.out.println(l1.stream().map(log16).map(Object::toString).collect(Collectors.joining("\n")));
    }
}
