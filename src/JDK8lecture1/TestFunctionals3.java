package JDK8lecture1;

import com.sun.org.apache.xpath.internal.SourceTree;
import lecture3.Complex;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by mpividori on 01/09/2016.
 */
public class TestFunctionals3 {
    public static void main(String[] args) {

        System.out.println("Begin");
        Function<OverloadingClass, String> prova = OverloadingClass::method;

        System.out.println(prova.apply(new OverloadingClass()));    //should obtain default method

        BiFunction<OverloadingClass, Integer, String> prova2 = OverloadingClass::method;

        System.out.println(prova2.apply(new OverloadingClass(), 1));    //should obtain overloaded method

        System.out.println("\n Other test more practical");
        BiFunction<Complex, Complex, Complex> sommaComplexComplex = Complex::add;
        BiFunction<Complex, Double, Complex> sommaComplexDouble = Complex::add;

        Complex a = new Complex(1.23, 4.56);
        Complex b = new Complex(9.87, 6.54);
        double c = 1.11;

        System.out.println(sommaComplexComplex.apply(a,b));
        System.out.println(sommaComplexDouble.apply(a,c));

    }
}
