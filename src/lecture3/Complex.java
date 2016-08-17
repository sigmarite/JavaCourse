package lecture3;

/**
 * Created by mpividori on 12/08/16.
 */
public class Complex {

    double real;
    double im;

    /*------------------------------------------------------------------------------------------------------------------
    MODULUS AND PHASE
    */

    public double getMod() {
        return Math.sqrt(real*real + im*im);
    }

    public double getPhase() {
        return Math.atan2(real, im);
    }

    /*------------------------------------------------------------------------------------------------------------------
    CONSTRUCTORS
    */

    public Complex(double real, double im) {
        this.real = real;   this.im = im;
    }

    public Complex(Complex other) {
        this(other.real, other.im);
    }

    public Complex(double d) {
        this(d, 0.);
    }

    /*------------------------------------------------------------------------------------------------------------------
    TOSTRING
    */

    public String toString() {
        return "CPLX[" + real + ", " + im +"]";
    }

    /*------------------------------------------------------------------------------------------------------------------
    GETTER AND SETTER
    */

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    /*------------------------------------------------------------------------------------------------------------------
    ADDITION OPERATIONS
    */

    public Complex add(Complex other) {
        return new Complex(real + other.real, im + other.im);
    }

    public Complex add(Complex... others){
        Complex c = new Complex(this);
        for (Complex other : others) {
            c = c.add(other);
        }
        return c;
    }

    public Complex add(double d) {
        return this.add(new Complex(d));                                //CORRECT LOGIC? PROBABLY FASTER WITHOUT RECASTING..
    }

    public Complex add(double... ds){                                   //IS IT POSSIBLE TO RECAST??
        Complex c = new Complex(this);
        for (double d : ds) {
            c = c.add(d);
        }
        return c;
    }

    /*------------------------------------------------------------------------------------------------------------------
    ADDTO OPERATIONS
    */

    public Complex addto(Complex other) {
        setReal(real + other.real);
        setIm(im + other.im);
        return this;
    }

    public Complex addto(Complex... others) {
        for (Complex other : others) {
            addto(other);
        }
        return this;
    }

    public Complex addto(double d) {
        Complex c = new Complex(d);
        return addto(c);
    }

    public Complex addto(double... ds) {
        for (double d : ds) {
            addto(d);
        }
        return this;
    }

    /*------------------------------------------------------------------------------------------------------------------
    SUBTRACTION OPERATIONS
    */

    public Complex sub(Complex other) {
        return new Complex(real - other.real, im - other.im);
    }

    public Complex sub(Complex... others){
        Complex c = new Complex(this);
        for (Complex other : others) {
            c = c.sub(other);
        }
        return c;
    }

    public Complex sub(double d) {
        return this.sub(new Complex(d));
    }

    public Complex sub(double... ds){
        Complex c = new Complex(this);
        for (double d : ds) {
            c = c.sub(d);
        }
        return c;
    }

    /*------------------------------------------------------------------------------------------------------------------
    SUBTO OPERATIONS
    */

    public Complex subto(Complex other) {
        setReal(real - other.real);
        setIm(im - other.im);
        return this;
    }

    public Complex subto(Complex... others) {
        for (Complex other : others) {
            subto(other);
        }
        return this;
    }

    public Complex subto(double d) {
        Complex c = new Complex(d);
        return subto(c);
    }

    public Complex subto(double... ds) {
        for (double d : ds) {
            subto(d);
        }
        return this;
    }

    /*------------------------------------------------------------------------------------------------------------------
    PRODUCT OPERATIONS (prod and prodto)
    */

    public Complex prod(Complex other){
        double newreal = real * other.real - im * other.im;
        double newim = im * other.real + real * other.im;
        return new Complex(newreal, newim);
    }

    public Complex prod (Complex... others){
        Complex c = new Complex(this);
        for (Complex other : others) {
            c = c.prod(other);
        }
        return c;
    }

    public Complex prod(double d){
        return prod(new Complex(d));
    }

    public Complex prod(double... ds){
        Complex c = new Complex(this);
        for (double d : ds) {
            c = c.prod(d);
        }
        return c;
    }

    public Complex prodto(Complex other){
        double newreal = real * other.real - im * other.im;
        double newim = im * other.real + real * other.im;
        setReal(newreal);
        setIm(newim);
        return this;
    }

    public Complex prodto(Complex... others) {
        for (Complex other : others) {
            prodto(other);
        }
        return this;
    }

    public Complex prodto(double d) {
        Complex c = new Complex(d);
        return prodto(c);
    }

    public Complex prodto(double... ds) {
        for (double d : ds) {
            prodto(d);
        }
        return this;
    }

    /*------------------------------------------------------------------------------------------------------------------
    INVERSE OPERATIONS
    */

    public Complex inverse() {
        double newreal = real/getMod();
        double newim = -im/getMod();
        return new Complex(newreal, newim);
    }

    public Complex inverseto() {
        double mod = getMod();
        setReal(real/mod);
        setIm(-im/mod);
        return this;
    }

    /*------------------------------------------------------------------------------------------------------------------
    DIVISION OPERATIONS
    */

    public Complex div(Complex other){
        return prod(other.inverse());
    }

    public Complex div(Complex... others){
        Complex c = new Complex(this);
        for (Complex other : others) {
            c = c.div(other);
        }
        return c;
    }

    public Complex div(double d){
        return div(new Complex(d));
    }

    public Complex div(double... ds){
        Complex c = new Complex(this);
        for (double d : ds) {
            c = c.div(d);
        }
        return c;
    }

    public Complex divto(Complex other){
        return prodto(other.inverse());
    }

    public Complex divto(Complex... others) {
        for (Complex other : others) {
            divto(other);
        }
        return this;
    }

    public Complex divto(double d) {
        Complex c = new Complex(d);
        return divto(c);
    }

    public Complex divto(double... ds) {
        for (double d : ds) {
            divto(d);
        }
        return this;
    }

    /*------------------------------------------------------------------------------------------------------------------
    CONJUGATE
    */

    public Complex conj() {
        return new Complex(real, -im);
    }

    /*------------------------------------------------------------------------------------------------------------------
    MODIFY MODULUS
    */

    public Complex setMod(double d){
        double diffmod = d/getMod();
        return prodto(diffmod);
    }

    /*------------------------------------------------------------------------------------------------------------------
    MODIFY PHASE
    */

    public Complex addPhase(double phi){
        return prod(new Complex(Math.cos(phi), Math.sin(phi)));
    }

    public Complex addPhaseTo(double phi){
        return prodto(new Complex(Math.cos(phi), Math.sin(phi)));
    }

    public Complex setPhase(double phi){
        double diffphase = phi-getPhase();
        return addPhaseTo(diffphase);
    }

}
