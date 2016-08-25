package lecture5;

/**
 * Created by mpividori on 25/08/16.
 */

class CharThread1 extends Thread { char c;
    CharThread1(char aChar) {
        c = aChar; }
    public void run() { while (true) {
        System.out.println(c); try {
            sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Interrupted"); }
    } }
}
