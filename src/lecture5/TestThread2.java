package lecture5;

/**
 * Created by mpividori on 25/08/16.
 */
public class TestThread2 {
    public static void main(String[] args) {
        CharThread2 r1 = new CharThread2('a'); CharThread2 r2 = new CharThread2('b');
        Thread t1 = new Thread(r1); Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
