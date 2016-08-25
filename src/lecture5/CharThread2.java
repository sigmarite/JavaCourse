package lecture5;

/**
 * Created by mpividori on 25/08/16.
 */
public class CharThread2 implements Runnable {
    char c;
    CharThread2(char aChar) {
        c = aChar;
    }
    public void run() {
        while (true) {
            System.out.println(c);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }
    }
}