package lecture6;

import lecture2.Book;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mpividori on 29/08/16.
 */
public class TestBookComparable {

    public static void main(String[] args) {
        List<Book> library = new LinkedList<>();
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "Cde", 123, "A123"));
        library.add(new Book("ee", "cde", 100, "A123"));
        library.add(new Book("z", "cde", 100, "A123"));
        library.add(new Book("ee", "cde", 12, "A123"));
        library.add(new Book("ee", "cde", 111, "A123"));
        library.add(new Book("ee", "dd", 100, "A123"));

        System.out.println("UNSORTED LIBRARY");
        for (Book b : library) {
            System.out.println(b);
        }

        Collections.sort(library);

        System.out.println("SORTED LIBRARY");
        for (Book b : library) {
            System.out.println(b);
        }


    }
}
