package lecture3b;

/**
 * Created by mpividori on 22/08/16.
 */
public class TestBTrees {

    public static void main(String[] args){
        System.out.println("EMPTY TREE");
        EmptyTree myempty = new EmptyTree();
        System.out.println(myempty);
        System.out.println("isEmpty   ->\t" + myempty.isEmpty());
        try {
            System.out.println("getLabel  ->\t" + myempty.getLabel());
        }
        catch (EmptyTreeException excp) {
            System.out.println("CORRECT getLabel EXCEPTION");
        }
        try {
            System.out.println("getLeft  ->\t" + myempty.getLeft());
        }
        catch (EmptyTreeException excp) {
            System.out.println("CORRECT getLeft EXCEPTION");
        }
        try {
            System.out.println("getRight  ->\t" + myempty.getRight());
        }
        catch (EmptyTreeException excp) {
            System.out.println("CORRECT getRight EXCEPTION");
        }
        System.out.println("length    ->\t" + myempty.length());
        System.out.println("nodes     ->\t" + myempty.numOfNodes());
        System.out.println("");

        System.out.println("LEAF");
        Leaf myleaf = new Leaf("LABELLEAF");
        System.out.println(myleaf);
        System.out.println("isEmpty   ->\t" + myleaf.isEmpty());
        System.out.println("getLabel  ->\t" + myleaf.getLabel());
        System.out.println("getLeft   ->\t" + myleaf.getLeft());
        System.out.println("getRight  ->\t" + myleaf.getRight());
        System.out.println("length    ->\t" + myleaf.length());
        System.out.println("nodes     ->\t" + myleaf.numOfNodes());
        System.out.println("");

        System.out.println("NODE");
        Node mynode = new Node("LABELNODE", new Leaf("RIGHTLEAF"), new Leaf("LEFTLEAF"));
        System.out.println(mynode);
        System.out.println("isEmpty   ->\t" + mynode.isEmpty());
        System.out.println("getLabel  ->\t" + mynode.getLabel());
        System.out.println("getLeft   ->\t" + mynode.getLeft());
        try {System.out.println("Left lab  ->\t" + mynode.getLeft().getLabel());}
        catch (EmptyTreeException excp) {System.out.println("Left lab  ->\tEMPTY");}
        System.out.println("getRight  ->\t" + mynode.getRight());
        try {System.out.println("Right lab ->\t" + mynode.getRight().getLabel());}
        catch (EmptyTreeException excp) {System.out.println("Right lab  ->\tEMPTY");}
        System.out.println("length    ->\t" + mynode.length());
        System.out.println("nodes     ->\t" + mynode.numOfNodes());
        System.out.println("");

        int n=5; int m=1;
        System.out.println("Tree generated by sequence " + n + ", " +  m + "->\t" + BTree.generateBTreeFromSequence(n, m));

        n=1; m=5;
        System.out.println("Tree generated by sequence " + n + ", " +  m + "->\t" + BTree.generateBTreeFromSequence(n, m));

        n=3; m=3;
        System.out.println("Tree generated by sequence " + n + ", " +  m + "->\t" + BTree.generateBTreeFromSequence(n, m));

        n=1; m=7;
        System.out.println("Tree generated by sequence " + n + ", " +  m + "->\t" + BTree.generateBTreeFromSequence(n, m));

    }
}
