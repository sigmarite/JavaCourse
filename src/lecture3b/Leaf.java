package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public class Leaf extends Node {

    Leaf(String label){
        super(label, new EmptyTree(), new EmptyTree());
    }

    public int length() {return 1;}
    public int numOfNodes() {return 1;}
}
