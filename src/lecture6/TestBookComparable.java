package lecture6;

import lecture2.Book;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mpividori on 29/08/16.
 */
public class TestBookComparable {

    public static void main(String[] args) {
        List<Book> library = new LinkedList<>();
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "cde", 100, "A123"));
        library.add(new Book("Abc", "cde", 100, "A123"));

    }
}
