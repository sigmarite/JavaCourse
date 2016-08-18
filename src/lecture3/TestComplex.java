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

        //TEST MODULUS AND PHASE
        System.out.println();

        System.out.println("MODULUS OF :\t" + a + "\t" + a.getMod());
        System.out.println("PHASE   OF :\t" + a + "\t" + a.getPhase());

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

        //TEST SUBTRACTION
        System.out.println();

        System.out.println("SUBTRACTION #1:\t" + a + " - " + b + " = " + a.sub(b));
        e = a.sub(b);
        System.out.println("SUBTRACTION #2:\t" + a + " - " + b + " = " + e);
        System.out.println("SUBTRACTION #3:\t" + a + " - " + 2.31 + " = " + a.sub(2.31));
        System.out.println("SUBTRACTION #4:\t" + a + " - " + b + " - " + c + " = " + a.sub(b, c));
        System.out.println("SUBTRACTION #5:\t" + a + " - " + 2.31 + " - " + 3.37 + " = " + a.sub(2.31, 3.37));

        //TEST SUBTO
        System.out.println();

        System.out.println("SUB TO TESTS:\t initial value->\t" + a);
        a.subto(b);
        System.out.println(a);
        a.subto(b,c);
        System.out.println(a);

        //TEST PRODUCT
        System.out.println();

        System.out.println("PRODUCT   #1:\t" + a + " * " + b + " = " + a.prod(b));
        e = a.prod(b);
        System.out.println("PRODUCT   #2:\t" + a + " * " + b + " = " + e);
        System.out.println("PRODUCT   #3:\t" + a + " * " + 2.31 + " = " + a.prod(2.31));
        System.out.println("PRODUCT   #4:\t" + a + " * " + b + " * " + c + " = " + a.prod(b, c));
        System.out.println("PRODUCT   #5:\t" + a + " * " + 2.31 + " * " + 3.37 + " = " + a.prod(2.31, 3.37));

        //TEST PRODTO
        System.out.println();

        System.out.println("PROD TO TESTS:\t initial value->\t" + a);
        a.prodto(b);
        System.out.println(a);
        a.prodto(b,c);
        System.out.println(a);

        //RESET
        a = new Complex(1., 1.);
        b = new Complex(2., 2.);
        c = new Complex(3., 0.);
        d = new Complex(0., 4.);

        //TEST INVERSE
        System.out.println();

        System.out.println("INVERSE OF :\t" + a + " = " + a.inverse());

        //TEST DIVISION
        System.out.println();

        System.out.println("DIVISION   #1:\t" + a + " / " + b + " = " + a.div(b));
        e = a.div(b);
        System.out.println("DIVISION   #2:\t" + a + " / " + b + " = " + e);
        System.out.println("DIVISION   #3:\t" + a + " / " + 2.31 + " = " + a.div(2.31));
        System.out.println("DIVISION   #4:\t" + a + " / " + b + " / " + c + " = " + a.div(b, c));
        System.out.println("DIVISION   #5:\t" + a + " / " + 2.31 + " / " + 3.37 + " = " + a.div(2.31, 3.37));

        //TEST DIVTO
        System.out.println();

        System.out.println("DIV TO TESTS:\t initial value->\t" + a);
        a.divto(b);
        System.out.println(a);
        a.divto(b,c);
        System.out.println(a);

        //RESET
        a = new Complex(1., 1.);
        b = new Complex(2., 2.);
        c = new Complex(3., 0.);
        d = new Complex(0., 4.);

        //TEST CONJUGATE
        System.out.println();

        System.out.println("CONJUGATE OF:\t" + a + " = " + a.conj());

        //TEST SET MODULUS AND PHASE
        System.out.println();

        System.out.println("SETTING MODULUS TO 5.0:\t" + a + " = " + a.setMod(5.));
        System.out.println("SETTING PHASE  TO 1.57:\t" + a + " = " + a.setPhase(1.57));



    }
}
