package lecture5;

/**
 * Created by mpividori on 25/08/16.
 */
public class TestThread {
    public static void main(String[] args) {
        CharThread1 t1 = new CharThread1('a'); CharThread1 t2 = new CharThread1('b');
        t1.start();
        t2.start();
    }
}
