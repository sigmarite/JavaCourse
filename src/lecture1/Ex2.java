package lecture1;

import java.util.Scanner;

/**
 * Exercises on loops
 */
public class Ex2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Counting to ten");
        for (byte i=1; i<11; i++){
            System.out.print(""+i+" ");
        }
        System.out.println();

        ////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("While cycle");
        String test="y";
        while (!(test.equals("n"))) {                                   //CARE! didnt't work with !=  ... are string not equivalents but equal?
            System.out.println("Do you want to continue? (y/n)");
            test = scanner.next();
            System.out.println(test == "n");
            System.out.println(test.equals("n"));
            System.out.println(test.equals("n\n"));                     //!!!
        }

        ////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("Some check on equality");
        char testChar = 'b';
        String testString = "b";                                        //CARE! "" instead of '' for String (confirmed with SOE)
        System.out.println("Char equivalence "+(testChar=='b'));
        System.out.println("String equivalence "+(testString=="b"));    //CARE!  here instead equivalency holds... strange.. issue of Scanner? newline char?





    }
}
