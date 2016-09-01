package JDK8lecture1;

import java.util.function.Function;

/**
 * Created by mpividori on 01/09/2016.
 */
public class TestFunctionals2 {

    public static void main(String[] args) {

        Function<Integer, Integer> f1 = x -> x + 2;
        Function<Integer, Integer> f2 = x -> x * 3;

        System.out.println(f1.andThen(f2).apply(5));    //prima applica f1 a 5 (result 7) e poi f2 a 7 (final result 21)
        System.out.println(f1.compose(f2).apply(5));    //prima applica f2 a 5 (result 15) e poi f1 a 15 (final result 17)

        System.out.println(f1.compose(f1).compose(f2).andThen(f2).apply(3));  // f2(3)=9 -> f1(9)=11 -> f1(11)=13 and then f2(13) = 39

    }

}
