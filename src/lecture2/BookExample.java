package lecture2;


/**
 * Created by mpividori on 11/08/16.
 */
public class BookExample {
    public static void main(String[] vars) {

        Book b1 = new Book("Example Title", "Example Author", 100, "A32DCFFF2");

        System.out.println(b1.getInitials());

    }
}
