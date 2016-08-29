package lecture6;

/**
 * Created by mpividori on 29/08/16.
 */
public class TestMyStack {

    public static void main(String[] args) {
        MyStack<Integer> aStack = new MyStack<>();

        aStack.push(5);
        aStack.push(2);
        aStack.push(10);

        try {
            System.out.println(aStack.peek());
        } catch (EmptyMyStackException e) {
            System.out.println("Empty stack!");
        }

        for (int i=0; i<4; i++) {
            try {
                System.out.println(aStack.pop());
            } catch (EmptyMyStackException e) {
                System.out.println("Empty stack!");
            }
        }
    }
}
