package lecture6;

import java.util.LinkedList;

/**
 * Created by mpividori on 29/08/16.
 */
public class MyStack<BaseType>  {
    private LinkedList<BaseType> data;

    MyStack() {
        data = new LinkedList<BaseType>();
    }

    public void push(BaseType d) {
        data.addFirst(d);
    }

    public BaseType pop() throws EmptyMyStackException {
        if (isEmpty()) throw new EmptyMyStackException();
        return data.removeFirst();
    }

    public BaseType peek() throws EmptyMyStackException  {
        if (isEmpty()) throw new EmptyMyStackException();
        return data.peekFirst();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}

