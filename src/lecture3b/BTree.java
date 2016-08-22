package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public abstract class BTree {
    public abstract boolean isEmpty();
    public abstract String getLabel();
    public abstract BTree getRight();
    public abstract BTree getLeft();
    public abstract int length();
    public abstract int numOfNodes();
}
