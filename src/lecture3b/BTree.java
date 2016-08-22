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
    public abstract String toString();

    public static BTree generateBTreeFromSequence(int n, int m){
        if (n > m) {return new EmptyTree();}
        else if (n == m) {return new Leaf("" + n);}
        else {
            int i = (n + m)/2 ;
            return new Node("" + n, generateBTreeFromSequence(n, i), generateBTreeFromSequence(i, m) );
        }
    }
}
