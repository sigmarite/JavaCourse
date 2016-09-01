package JDK8lecture1;

import lecture2.Book;

import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * Created by mpividori on 31/08/2016.
 */
public class TestFunctionals1 {

    public static void main(String[] args) {

        MyIntFunction prova = x -> "test";
        MyIntFunction<Character> prova2 = x -> (char)4;
        MyIntFunction<Book> prova3 = x -> new Book("A", "B", 2, "ss");
        System.out.println(prova.apply(2));
        System.out.println(prova2.apply(2));
        System.out.println(prova3.apply(2));
    }
}
