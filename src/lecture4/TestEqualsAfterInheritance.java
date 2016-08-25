package lecture4;

import lecture2.Book;
import java.util.Objects;


/**
 * Created by mpividori on 24/08/16.
 */
public class TestEqualsAfterInheritance {
    public static void main(String[] args) {
        Book b1 = new Book("Titolo", "Autore", 101, "A123");
        ScientificBook sb1 = new ScientificBook("Titolo", "Autore", 101, null, "A123", "JAVA");

        System.out.println("sb1.equals(b1) ->\t" + sb1.equals(b1));                 //EXPECTED false (classi diverse!)
        System.out.println("sb1.superEquals(b1) ->\t" + sb1.superEquals(b1));       //EXPECTED false
        System.out.println("b1.equals(sb1) ->\t" + b1.equals(sb1));                 //EXPECTED false
        System.out.println("Object.equals(b1, sb1) ->\t" + (Objects.equals(b1, sb1)));  //??
        System.out.println("Object.equals(sb1, b1) ->\t" + (Objects.equals(sb1, b1)));  //??

        System.out.println("Book.equals(b1, sb1) ->\t" + Book.equals(b1, sb1));     //EXPECTED true
        System.out.println("ScientificBook.equals(b1, sb1) ->\t" + ScientificBook.equals(b1, sb1));     //EXPECTED false

    }
}
