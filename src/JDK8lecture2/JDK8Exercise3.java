package JDK8lecture2;

import lecture2.Book;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by mpividori on 12/09/2016.
 */
public class JDK8Exercise3 {
    public static void main(String[] args) {
        Book b1 = new Book("Java 8 lambdas", "Richard Warbuton", 182, "O'Reilly");
        Book b2 = new Book("Java 8 in action", "Raoul-Gabriel Urma", 497, "Manning");
        Book b3 = new Book("Functional thinking", "Neal Ford", 179, "O'Reilly");
        Book b4 = new Book("Learning scala", "Jason Swartz", 255, "O'Reilly");
        Book b5 = new Book("Parallel and concurrent programming in Haskell",
                "Simon Marlow", 321, "O'Reilly");
        Book b6 = new Book("Presentation patterns", "Neal Ford", 265,
                "Addisson Wesley");
        List<Book> books = Arrays.asList(b1, b2, b3, b4, b5, b6);

        //Exercise 1a
        List<Integer> ex1a = books.stream().map(Book::getNumOfPages).collect(Collectors.toList());
        System.out.println("Ex 1a: list of number of pages ->\t" + ex1a);

        //Exercise 1b
        List<String> ex1b = books.stream().map(Book::getAuthor).distinct().collect(Collectors.toList());
        System.out.println("Ex 1b: list of authors without duplicates ->\t" + ex1b);

        //Exercise 1c
        List<String> ex1c = books.stream().filter(b -> b.getISBN().equals("O'Reilly")).map(Book::getTitle).collect(Collectors.toList());
        System.out.println("Ex 1c: list of titles from O'Reilly ->\t" + ex1c);

        //Exercise 1d
        List<String> ex1d = books.stream().map(Book::getTitle).filter(str -> str.contains("Java")).collect(Collectors.toList());
        System.out.println("Ex 1d: list of titles about Java ->\t" + ex1d);

        //Exercise 1e
        List<String> ex1e = books.stream().map(b -> b.getAuthor().split(" ")[1]).distinct().collect(Collectors.toList());
        System.out.println("Ex 1e: ordered list of surnames without duplicates ->\t" + ex1e);

        //Exercise 1f
        Optional<Book> ex1f = books.stream().sorted((book1, book2) -> book2.getTitle().length()-book1.getTitle().length()).findFirst();
        System.out.println("Ex 1f: book with longest title ->\t" + ex1f);

        //Exercise 1g
        Optional<String> ex1g = books.stream().sorted((book1, book2) -> book2.getNumOfPages()-book1.getNumOfPages()).map(Book::getTitle).findFirst();
        System.out.println("Ex 1g: title of the book with largest number of pages ->\t" + ex1g);

        //Exercise 1h
        OptionalDouble ex1h = books.stream().filter(b -> b.getISBN().equals("O'Reilly")).map(Book::getNumOfPages).mapToDouble(x -> x).average();
        System.out.println("Ex 1h: average number of pages of books from O'Reilly ->\t" + ex1h);

        //Exercise 1i
        Map<String, Integer> ex1i = books.stream().collect(Collectors.toMap(Book::getISBN, book -> 1, (x, y) -> x + y));
        System.out.println("Ex 1i: number of books from each publisher ->\t" + ex1i);

        //Exercise 1l
        Map<String, Double> ex1l = books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getNumOfPages)));
        System.out.println("Ex 1l: average number of pages from each author ->\t" + ex1l);



    }
}
