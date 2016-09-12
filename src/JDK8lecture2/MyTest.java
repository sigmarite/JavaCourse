package JDK8lecture2;

import automatedDOE.Scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by mpividori on 12/09/2016.
 */
public class MyTest {
    List<String> arr = Arrays.asList("Mariapia", "Teresa", "Stefano", "Marco");

    private String filter(Predicate<String> p){
        StringBuilder builder = new StringBuilder();
        for (String str: arr) {
            if (p.test(str)) builder.append(str);
        }
        return new String(builder);
    }

    private String update(Function<String, String> f) {
        StringBuilder builder = new StringBuilder();
        for (String str: arr) {
            builder.append(f.apply(str));
        }
        return new String(builder);
    }


    public static void main(String[] args) {
        MyTest test = new MyTest();

        Predicate<String> filter1 = str -> str.length() < 7;
        Predicate<String> filter2 = str -> str.length() > 7;
        System.out.println(test.filter(filter1));
        System.out.println(test.filter(filter2));
        System.out.println();

        Function<String, String> mod1 = String::toUpperCase;
        Function<String, String> mod2 = String::toLowerCase;
        System.out.println(test.update(mod1));
        System.out.println(test.update(mod2));
        System.out.println();



    }

}
