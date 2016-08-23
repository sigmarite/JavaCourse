package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public class EmptyTree extends BTree {
    public String toString(){return "[*]";}
    public boolean isEmpty() { return true;}
    public String getLabel() throws EmptyTreeException { throw new EmptyTreeException();}
    public BTree getRight() throws EmptyTreeException { throw new EmptyTreeException();}
    public BTree getLeft() throws EmptyTreeException { throw new EmptyTreeException();}
    public int length() {return 0;}
    public int numOfNodes() {return 0;}
}
