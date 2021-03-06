package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public abstract class BTree {
    public abstract boolean isEmpty();
    public abstract String getLabel() throws EmptyTreeException;
    public abstract BTree getRight() throws EmptyTreeException;
    public abstract BTree getLeft() throws EmptyTreeException;
    public abstract int length();
    public abstract int numOfNodes();
    public abstract String toString();

    public static BTree generateBTreeFromSequence(int n, int m){
        if (n > m) {return new EmptyTree();}
        else if (n == m) {return new Leaf("" + n);}
        else {
            int i = (n + 1 + m)/2 ;
            return new Node("" + n, generateBTreeFromSequence(n+1, i), generateBTreeFromSequence(i+1, m) );
        }
    }
}
