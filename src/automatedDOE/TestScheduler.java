package automatedDOE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpividori on 29/08/2016.
 */
public class TestScheduler {

    public static void main(String[] args)  {
        List<Integer> outputList = new ArrayList<>();
        outputList.add(1);
        outputList.add(2);
        outputList.add(5);


        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(5);
        inputList.add(10);
        inputList.add(20);
        inputList.add(50);
        inputList.add(100);

        List<Integer> valList = new ArrayList<>();
//        valList.add(1);
//        valList.add(5);
        valList.add(10);
        valList.add(20);
        valList.add(50);
        valList.add(100);
        valList.add(1000);
        valList.add(2000);
        valList.add(5000);
        valList.add(10000);
        valList.add(100000);


        System.out.println("nOut\tnInt\tnVal\tSCHEDULER");
        for (int nOut: outputList){
            for (int nInt: inputList) {
                for (int nVal: valList){
//                    System.out.println("MIN:\t" + Scheduler.minDOEsize(nVal, nInt, nOut) +"\tMAX:\t "+ Scheduler.maxDOEsize(nVal, nInt, nOut));
                    try {
                        System.out.println("" + nOut + "\t\t" + nInt + "\t\t" + nVal + "\t\t" + new Scheduler(nVal, nInt, nOut));
                    } catch (FewEvaluationException e) {System.out.println("Too few evaluations!");}
                }
                System.out.println("");
            }
        }
    }
}
