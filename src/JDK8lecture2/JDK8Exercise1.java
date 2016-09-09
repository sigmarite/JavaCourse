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
    Tutte le funzioni (eccetto alcuni predicati di tipo) ritornano come valore un Object
    (perchè ogni funzione può ritornare undefined come risposta).
*/

public class JDK8Exercise1 {

    private static final String UNDEFINED = "UNDEFINED";

    public static void main(String[] args) {

        Predicate<Object> isUndefined = x ->
                x.equals(UNDEFINED) ||
                x instanceof ArrayList && ((ArrayList)x).contains(UNDEFINED);


        ///////////////////////////////////////////////////////////////////////////////////////////////
        // ex1
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> len = inputList -> {
            if (isUndefined.test(inputList)) return UNDEFINED;
            int length = 0;
            for (Object el : inputList) length++;
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

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex2
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> member = inputList -> {
            if (isUndefined.test(inputList) ||
                    !(len.apply(inputList).equals(2))) return UNDEFINED;
            try {
                ArrayList<Object> list = (ArrayList)inputList.get(1);
                return list.contains(inputList.get(0));
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

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex3
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> count0 = inputList -> {
            if (isUndefined.test(inputList)) return UNDEFINED;
            int count = 0;
            for (Object el: inputList) {
                if (el.equals(0)) count++;
            }
            return count;
        };
        ArrayList<Object> ex3inp1 = new ArrayList<>(
                Arrays.asList(1, 2, 3));
        ArrayList<Object> ex3inp2 = new ArrayList<>();
        ArrayList<Object> ex3inp3 = new ArrayList<>(
                Arrays.asList(3, 4, 0));
        ArrayList<Object> ex3inp4 = new ArrayList<>(
                Arrays.asList(0, 1, 2, 0));
        System.out.println("\nExercise3: count0()");
        System.out.println("count0("+ex3inp1+") ->\t"+count0.apply(ex3inp1)+"\t (expected 0)");
        System.out.println("count0("+ex3inp2+") ->\t"+count0.apply(ex3inp2)+"\t (expected 0)");
        System.out.println("count0("+ex3inp3+") ->\t"+count0.apply(ex3inp3)+"\t (expected 1)");
        System.out.println("count0("+ex3inp4+") ->\t"+count0.apply(ex3inp4)+"\t (expected 2)");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex4
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Predicate<Object> isList = input -> input instanceof ArrayList;
        Predicate<ArrayList<Object>> isMultilevelList = inputList -> {
            if (len.apply(inputList).equals(0)) return false;
            boolean query = true;
            for (Object el : inputList) {
                query = query && isList.test(el);
            }
            return query;
        };
        assertEquals(isList.test(UNDEFINED), false);
        assertEquals(isList.test(1), false);
        assertEquals(isList.test(new ArrayList<>()), true);
        assertEquals(isMultilevelList.test(new ArrayList<>()), false);
        assertEquals(isMultilevelList.test(new ArrayList<>(Collections.singletonList(new ArrayList<>()))), true);
        Function<ArrayList<Object>, Object> concat = inputList -> {
            if (isUndefined.test(inputList) ||
                    !(len.apply(inputList).equals(2)) ||
                    !(isList.test(inputList.get(0))) ||
                    !(isList.test(inputList.get(1)))) return UNDEFINED;
            ArrayList<Object> sublist1 = (ArrayList)inputList.get(0);
            ArrayList<Object> sublist2 = (ArrayList)inputList.get(1);
            ArrayList<Object> list = new ArrayList<>(sublist1);
            for (Object el : sublist2) {
                list.add(el);
            }
            return list;
        };
        ArrayList<Object> ex4inp1 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2, 3)), new ArrayList<>(
                        Arrays.asList(4, 5))));
        ArrayList<Object> ex4inp2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2)), new ArrayList<>()));
        ArrayList<Object> ex4inp3 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(), new ArrayList<>()));
        System.out.println("\nExercise4: concat()");
        System.out.println("concat("+ex4inp1+") ->\t"+concat.apply(ex4inp1)+"\t (expected <1, 2, 3, 4, 5>)");
        System.out.println("concat("+ex4inp2+") ->\t"+concat.apply(ex4inp2)+"\t (expected <1, 2>)");
        System.out.println("concat("+ex4inp3+") ->\t"+concat.apply(ex4inp3)+"\t (expected <>)");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex5
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Predicate<Object> isInteger = input -> input instanceof Integer;
        Predicate<ArrayList<Object>> isIntegerList = inputList -> {
            boolean query = true;
            for (Object el : inputList) {
                query = query && isInteger.test(el);
            }
            return query;
        };
        Predicate<ArrayList<Object>> isBilevelList = inputList -> {
            if (len.apply(inputList).equals(0)) return false;
            boolean query = true;
            for (Object el : inputList) {
                if (!(isList.test(el))) return false;
                query = query && isIntegerList.test((ArrayList) el);
            }
            return query;
        };
        assertEquals(isInteger.test(UNDEFINED), false);
        assertEquals(isInteger.test(1), true);
        assertEquals(isInteger.test(new ArrayList<>(Arrays.asList(1, 2, 3))), false);
        assertEquals(isIntegerList.test(new ArrayList<>(Arrays.asList(1, 2, 3))), true);
        assertEquals(isIntegerList.test(new ArrayList<>(Arrays.asList(1, 2, UNDEFINED))), false);
        assertEquals(isIntegerList.test(new ArrayList<>(Arrays.asList(1, 2, new ArrayList<>()))), false);
        assertEquals(isBilevelList.test(new ArrayList<>(Arrays.asList(new ArrayList<>()))), true);
        assertEquals(isBilevelList.test(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(new ArrayList<>()))))), false);
        Function<ArrayList<Object>, Object> avg = inputList -> {
            if (isUndefined.test(inputList) || !(isIntegerList.test(inputList))) return UNDEFINED;
            double average = 0.;
            for (Object el : inputList){
                average += (int)el;
            }
            if (len.apply(inputList).equals(0)) return 0;
            else return average / (int)len.apply(inputList);
        };
        ArrayList<Object> ex5inp1 = new ArrayList<>(
                Arrays.asList(3, 6, 9));
        ArrayList<Object> ex5inp2 = new ArrayList<>();
        ArrayList<Object> ex5inp3 = new ArrayList<>(
                Collections.singletonList(4));
        ArrayList<Object> ex5inp4 = new ArrayList<>(
                Arrays.asList(0, 2, 2, 0));
        System.out.println("\nExercise5: avg()");
        System.out.println("avg("+ex5inp1+") ->\t"+avg.apply(ex5inp1)+"\t (expected 6)");
        System.out.println("avg("+ex5inp2+") ->\t"+avg.apply(ex5inp2)+"\t (expected 0)");
        System.out.println("avg("+ex5inp3+") ->\t"+avg.apply(ex5inp3)+"\t (expected 4)");
        System.out.println("avg("+ex5inp4+") ->\t"+avg.apply(ex5inp4)+"\t (expected 1)");
        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex6
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> prodList = inputList -> {
            if (isUndefined.test(inputList) ||
                    !(isIntegerList.test(inputList))) return UNDEFINED;
            int product = 1;
            for (Object el : inputList){
                product *= (int)el;
            }
            return product;
        };
        ArrayList<Object> ex6inp1 = new ArrayList<>(
                Arrays.asList(3, 1, 2));
        ArrayList<Object> ex6inp2 = new ArrayList<>();
        ArrayList<Object> ex6inp3 = new ArrayList<>(
                Collections.singletonList(4));
        ArrayList<Object> ex6inp4 = new ArrayList<>(
                Arrays.asList(0, 2, 2, 0));
        System.out.println("\nExercise6: prodList()");
        System.out.println("prodList("+ex6inp1+") ->\t"+prodList.apply(ex6inp1)+"\t (expected 6)");
        System.out.println("prodList("+ex6inp2+") ->\t"+prodList.apply(ex6inp2)+"\t (expected 1)");
        System.out.println("prodList("+ex6inp3+") ->\t"+prodList.apply(ex6inp3)+"\t (expected 4)");
        System.out.println("prodList("+ex6inp4+") ->\t"+prodList.apply(ex6inp4)+"\t (expected 0)");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex7
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> prod = inputList -> {
            if (isUndefined.test(inputList) ||
                    !(isIntegerList.test(inputList)) ||
                    !(len.apply(inputList).equals(2))) return UNDEFINED;
            int product = 0;
            for (int i=0; i<(int)inputList.get(1);i++){
                product += (int)inputList.get(0);
            }
            return product;
        };
        ArrayList<Object> ex7inp1 = new ArrayList<>(
                Arrays.asList(3, 4));
        ArrayList<Object> ex7inp2 = new ArrayList<>(
                Arrays.asList(3, 0));
        ArrayList<Object> ex7inp3 = new ArrayList<>(
                Arrays.asList(2, 1));
        System.out.println("\nExercise7: prod()");
        System.out.println("prod("+ex7inp1+") ->\t"+prod.apply(ex7inp1)+"\t (expected 12)");
        System.out.println("prod("+ex7inp2+") ->\t"+prod.apply(ex7inp2)+"\t (expected 0)");
        System.out.println("prod("+ex7inp3+") ->\t"+prod.apply(ex7inp3)+"\t (expected 2)");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex8
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> rev = inputList -> {
            if (isUndefined.test(inputList)) return UNDEFINED;
            ArrayList<Object> list = new ArrayList<>();
            for (Object el: inputList) {
                list.add(0, el);
            }
            return list;
        };
        ArrayList<Object> ex8inp1 = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Object> ex8inp2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2)), new ArrayList<>(
                        Arrays.asList(3, 4))));
        ArrayList<Object> ex8inp3 = new ArrayList<>();
        System.out.println("\nExercise8: rev()");
        System.out.println("rev("+ex8inp1+") ->\t"+rev.apply(ex8inp1)+"\t (expected <5, 4, 3, 2, 1>)");
        System.out.println("rev("+ex8inp2+") ->\t"+rev.apply(ex8inp2)+"\t (expected <<3, 4>, <1, 2>>)");
        System.out.println("rev("+ex8inp3+") ->\t"+rev.apply(ex8inp3)+"\t (expected <>)");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex9
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> allrev = inputList -> {
            if ((isUndefined.test(inputList)) ||
                    !(isMultilevelList.test(inputList))) return UNDEFINED;
            ArrayList<Object> list = new ArrayList<>();
            for (Object el: inputList) {
                list.add(rev.apply((ArrayList<Object>)el));
            }
            return list;
        };
        ArrayList<Object> ex9inp1 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2, 3)), new ArrayList<>(
                        Arrays.asList(4, 5))));
        ArrayList<Object> ex9inp2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2)), new ArrayList<>(), new ArrayList<>(
                        Arrays.asList(4, 5, 6))));
        ArrayList<Object> ex9inp3 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(), new ArrayList<>()));
        System.out.println("\nExercise9: allrev()");
        System.out.println("allrev("+ex9inp1+") ->\t"+allrev.apply(ex9inp1)+"\t (expected <<3, 2, 1>, <5, 4>>)");
        System.out.println("allrev("+ex9inp2+") ->\t"+allrev.apply(ex9inp2)+"\t (expected <<2, 1>, <>, <6, 5, 4>>)");
        System.out.println("allrev("+ex9inp3+") ->\t"+allrev.apply(ex9inp3)+"\t (expected <<>, <>>)");

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //ex10
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Function<ArrayList<Object>, Object> flatten = inputList -> {
            if ((isUndefined.test(inputList)) ||
                    !(isBilevelList.test(inputList))) return UNDEFINED;
            ArrayList<Object> list = new ArrayList<>();
            for (Object el: inputList) {
                Object temp = concat.apply(new ArrayList<>(
                        Arrays.asList(list, el)));
                if (isUndefined.test(temp)) return UNDEFINED;
                list = (ArrayList) temp;
            }
            return list;
        };
        ArrayList<Object> ex10inp1 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2, 3)), new ArrayList<>(
                        Arrays.asList(4, 5))));
        ArrayList<Object> ex10inp2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(
                        Arrays.asList(1, 2)), new ArrayList<>(), new ArrayList<>(
                        Arrays.asList(4, 5, 6))));
        ArrayList<Object> ex10inp3 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(
                        Arrays.asList(3, 4)), new ArrayList<>()));
        System.out.println("\nExercise10: flatten()");
        System.out.println("flatten("+ex10inp1+") ->\t"+flatten.apply(ex10inp1)+"\t (expected <1, 2, 3, 4, 5>)");
        System.out.println("flatten("+ex10inp2+") ->\t"+flatten.apply(ex10inp2)+"\t (expected <1, 2, 4, 5, 6>)");
        System.out.println("flatten("+ex10inp3+") ->\t"+flatten.apply(ex10inp3)+"\t (expected <3, 4>)");




    }
}


