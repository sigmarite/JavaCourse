package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public class Node extends BTree{
    private String label;
    private BTree right, left;

    Node (String label, BTree right, BTree left){
        this.label = label; this.right = right; this.left = left;
    }

    public boolean isEmpty() {return false;}
    public  String getLabel(){return label;}
    public  BTree getRight(){return right;};
    public  BTree getLeft(){return left;};
    public int length(){
        return Math.max(right.length(), left.length()) + 1;
    }
    public int numOfNodes() {
        return right.numOfNodes() + left.numOfNodes() + 1;
    }
}
