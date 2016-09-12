package JDK8lecture2;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by mpividori on 12/09/2016.
 */
public class JDK8Exercise2 {
    public static void main(String[] args) {
        //FIRST TASK
        IntFunction<Integer> f = x -> x + 1;
        System.out.println("FIRST TASK: Simple function call");
        System.out.println("Call '+1' with argument 1:\t" + f.apply(1) + "\n");

        //SECOND TASK
        Predicate<Integer> even = i -> i%2 == 0 ;
        Predicate<Integer> odd = even.negate();
        System.out.println("SECOND TASK: Even and odd");
        for (int i = 0; i < 3; i++) {
            System.out.println("even(" + i + ") = " + even.test(i));
            System.out.println("odd(" + i + ") = " + odd.test(i));
        }
        System.out.println();

        //FOURTH TASK
        List<String> arr = Arrays.asList("Mariapia", "Teresa", "Stefano", "Marco");
        arr.sort((str1, str2) -> str1.length() - str2.length());
        System.out.println("FOURTH TASK: Sorting and lambda functions");
        System.out.println(arr);
        System.out.println();

        //FIFTH TASK
        Consumer<String> print = str -> System.out.println("EVALUATED ONLY NOW!\n" + str);
        System.out.println("FIFTH TASK: Demonstrate lazy evaluation\nBefore evaluating");
        print.accept("After evaluating");
        System.out.println();

        //SIXTH TASK
        List<Double> dblList = Arrays.asList(1.23, 4.56, 7.89);
        BiFunction<Double, Double, Double> binaryAdd = (x, y) -> x + y;
        Function<Double, Function<Double, Double>> unaryAdd = x -> (y -> binaryAdd.apply(x, y));
        Function<Double, Double> sum = unaryAdd.apply(0.);
        for (Double d: dblList) {
            Double temp = sum.apply(d);
            sum = unaryAdd.apply(temp);
        }
        System.out.println("FIFTH TASK: Demonstrate currying");
        System.out.println("Internal sum of array:\t" + sum.apply(0.));
    }
}
