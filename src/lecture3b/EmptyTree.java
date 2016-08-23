package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public class EmptyTree extends BTree {
    public String toString(){return "[*]";}
    public boolean isEmpty() { return true;}
    public String getLabel() { System.out.println("ERROR!"); return "ERROR!";}
    public BTree getRight() {System.out.println("ERROR!"); return this;}
    public BTree getLeft() {System.out.println("ERROR!"); return this;}
    public int length() {return 0;}
    public int numOfNodes() {return 0;}
}
