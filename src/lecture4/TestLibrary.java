package lecture4;

import lecture2.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpividori on 25/08/16.
 */
public class TestLibrary {

    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book("Titolo" ,"Autore Anonimo", 101, "ABC123");
        ScientificBook sb1 = new ScientificBook(b1, "AREA");
        List<String> topics = new ArrayList<String>();
        topics.add("TOPIC1");
        topics.add("TOPIC2");
        NovelBook nb1 = new NovelBook(b1, topics );
        nb1.setTitle("NuovoTitolo");

        lib.addBook(b1);
        lib.addBook(sb1);
        lib.addBook(nb1);
        System.out.println(lib.containsBook(b1));
        System.out.println(lib.searchForTitle("NuovoTitolo"));

    }




}
