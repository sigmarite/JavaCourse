package lecture2;


/**
 * Created by mpividori on 11/08/16.
 */
public class BookExample {
    public static void main(String[] vars) {
        String[] topics = {"topic1", "topic2"};
        //Book b1 = new Book("Example Title", "Example Author", 100, {"topic1","topic2"}, "A32DCFFF2");     !!DOESN'T WORK
        Book b1 = new Book("Example Title", "Example Author", 100, topics, "A32DCFFF2");

        System.out.println(b1.getInitials());

    }
}
