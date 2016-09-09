package JDK8lecture2;

import automatedDOE.Scheduler;

import java.util.*;
import java.util.function.*;
import static org.junit.Assert.*;

/**
 * Created by mpividori on 08/09/2016.
 */

/* In questo programma sostituisco gli elementi <1, 2, 3> dell'esercizio con ArrayList<Object>.
    Tutte le funzioni avranno come argomento un unico oggetto ArrayList<Object>.
    Object nella pratica potrà essere solo Integer, "undefined" o un altro ArrayList.
    Tutte le funzioni (eccetto isundefined) ritornano come valore un Object
    (perchè ogni funzione può ritornare undefined come risposta).
*/

public class JDK8Exercise1 {

    static final String UNDEFINED = "UNDEFINED";

    public static void main(String[] args) {

        Predicate<Object> isundefined = x ->
                x.equals(UNDEFINED) ||
                x instanceof ArrayList && ((ArrayList)x).contains(UNDEFINED);

        //ex1
        Function<ArrayList<Object>, Object> len = inputlist -> {
            if (isundefined.test(inputlist)) return UNDEFINED;
            int length = 0;
            for (Object el : inputlist) length++;
            return length;
        };

        ArrayList<Object> ex1inp1 = new ArrayList<>(
                Arrays.asList(1, 2, 3));
        ArrayList<Object> ex1inp2 = new ArrayList<>();
        System.out.println("\nExercise1: len()");
        System.out.println("len("+ex1inp1+") ->\t"+len.apply(ex1inp1)+"\t (expected 3)");
        System.out.println("len("+ex1inp2+") ->\t"+len.apply(ex1inp2)+"\t (expected 0)");
        //further tests on len()
        ArrayList<Object> ex1test1 = new ArrayList<>(
                Arrays.asList(1, 2, UNDEFINED));
        assertEquals(len.apply(ex1test1),UNDEFINED);
        ArrayList<Object> ex1test2 = new ArrayList<>(
                Arrays.asList(1, 2, new ArrayList<>(
                        Arrays.asList(1, 2))));
        assertEquals(len.apply(ex1test2),3);

        //ex2
        Function<ArrayList<Object>, Object> member = inputlist -> {
            if (isundefined.test(inputlist) || !(len.apply(inputlist).equals(2))) return UNDEFINED;
            try {
                ArrayList<Object> list = (ArrayList<Object>)inputlist.get(1);
                return list.contains(inputlist.get(0));
            } catch (ClassCastException e) {return UNDEFINED;}
        };
        ArrayList<Object> ex2inp1 = new ArrayList<>(
                Arrays.asList(2, new ArrayList<>(
                        Arrays.asList(1, 2, 3)) ));
        ArrayList<Object> ex2inp2 = new ArrayList<>(
                Arrays.asList(6, new ArrayList<>()));
        ArrayList<Object> ex2inp3 = new ArrayList<>(
                Arrays.asList(2, new ArrayList<>(
                        Collections.singletonList(2)) ));
        ArrayList<Object> ex2inp4 = new ArrayList<>(
                Arrays.asList(4, new ArrayList<>(
                        Arrays.asList(1, 2, 3)) ));
        System.out.println("\nExercise2: member()");
        System.out.println("member("+ex2inp1+") ->\t"+member.apply(ex2inp1)+"\t (expected T)");
        System.out.println("member("+ex2inp2+") ->\t"+member.apply(ex2inp2)+"\t (expected F)");
        System.out.println("member("+ex2inp3+") ->\t"+member.apply(ex2inp3)+"\t (expected T)");
        System.out.println("member("+ex2inp4+") ->\t"+member.apply(ex2inp4)+"\t (expected F)");
        //further tests on len()
        assertEquals(member.apply(ex1test1), UNDEFINED);
        ArrayList<Object> ex2test1 = new ArrayList<>(
                Arrays.asList(1, new ArrayList<>(
                        Arrays.asList(1, 2, 3)), 3));
        assertEquals(member.apply(ex2test1), UNDEFINED); //three element list in input
        ArrayList<Object> ex2test2 = new ArrayList<>(
                Arrays.asList(1, 3));
        assertEquals(member.apply(ex2test2), UNDEFINED); //second element not a list
        ArrayList<Object> ex2test3 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2)), new ArrayList<>(
                        Arrays.asList(1, 2, 3))));
        assertEquals(member.apply(ex2test3), false); //first element is a sublist of second element
        ArrayList<Object> ex2test4 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2)), new ArrayList<>(
                        Arrays.asList(new ArrayList<>(
                                Arrays.asList(1, 2)), 3))));
        assertEquals(member.apply(ex2test4), true); //first element is a list contained in second element

        //ex3
        Function<ArrayList<Object>, Object> count0 = inputlist -> {
            if (isundefined.test(inputlist) || !(len.apply(inputlist).equals(2))) return UNDEFINED;
            int count = 0;
            for (Object el: inputlist) {
                if (el.equals(0)) count++;
            }
            return count;
        };

    }

}


