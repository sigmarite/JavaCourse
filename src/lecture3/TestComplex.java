package lecture3;

/**
 * Created by mpividori on 12/08/16.
 */
public class TestComplex {

    public static void main (String[] args) {

        //TEST CONSTRUCTORS AND TOSTRING
        Complex a = new Complex(1.523, 2.324);
        Complex b = new Complex(3.242, 1.323);
        Complex c = new Complex(b);
        Complex d = new Complex(4.232);


        System.out.println("CONSTRUCTOR:\t" + a + "\t" + b + "\t" + d);

        //TEST ADDITION
        System.out.println();


        System.out.println("ADDITION #1:\t" + a + " + " + b + " = " + a.add(b));
        Complex e = a.add(b);
        System.out.println("ADDITION #2:\t" + a + " + " + b + " = " + e);
        System.out.println("ADDITION #3:\t" + a + " + " + 2.31 + " = " + a.add(2.31));
        System.out.println("ADDITION #4:\t" + a + " + " + b + " + " + c + " = " + a.add(b, c));
        System.out.println("ADDITION #5:\t" + a + " + " + 2.31 + " + " + 3.37 + " = " + a.add(2.31, 3.37));

        //TEST ADDTO
        System.out.println();

        System.out.println("ADD TO TESTS");
        a.addto(b);
        System.out.println(a);
        a.addto(b,c);
        System.out.println(a);





    }
}
