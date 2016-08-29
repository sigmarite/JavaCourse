package automatedDOE;

import java.util.Map;

/**
 * Created by mpividori on 29/08/2016.
 */
public class Scheduler {

    private int DOESize;
    private int genSize;

    public Scheduler(int DOESize, int genSize) {
        this.DOESize = DOESize;
        this.genSize = genSize;
    }

    public Scheduler(int nVal, int nInt, int nOut) throws FewEvaluationException {
        this(0, 0);
        if (nVal < 5) throw new FewEvaluationException();
        int minDOE = minDOEsize(nVal, nInt, nOut);
        if (minDOE*10 > nVal) {     //Not enough evaluations to perform MOGA! Switch to only DOE
//            System.out.println("Not enough evaluations to perform MOGA! Switch to only DOE");
            setDOESize(nVal);
            setGenSize(1);
        }
        int maxDOE = maxDOEsize(nVal, nInt, nOut);
        if (maxDOE*50 < nVal) {     //Plenty of evaluations! DOE is set to max size and generations are boundless
//            System.out.println("Plenty of evaluations! DOE is set to max size and generations are boundless");
            setDOESize(maxDOE);
            setGenSize(nVal/maxDOE);
        }
        int bestDOE = minDOE; int bestGen = 10;
        double bestEval = evalDOE(bestDOE, minDOE, maxDOE) + evalGen(bestGen);
        for (int iGen=10; iGen<51; iGen++){
            int iDOE = nVal/iGen;
            iDOE = Math.min(iDOE, maxDOE);
            iDOE = Math.max(iDOE, minDOE);
            double eval = evalDOE(iDOE, minDOE, maxDOE) + evalGen(iGen);
//            System.out.println("#GEN\t" + iGen +"\t#DOE\t"+ iDOE + "\teval\t" + eval + "\tBEST\t" + bestEval);
            if (eval < bestEval) {
                bestEval = eval;
                bestDOE = iDOE;
                bestGen = iGen;
            }
        }
        setDOESize(bestDOE);
        setGenSize(nVal/bestDOE);

    }

    private double evalDOE(int iDOE, int minDOE, int maxDOE) {
        double k = 10.;
        return k * (maxDOE - iDOE) * (maxDOE - iDOE) /(maxDOE - minDOE)/(maxDOE - minDOE) ;
    }

    private double evalGen(int iGen) {
        double k = 10.;
        return k * (50 - iGen) * (50 - iGen) /1600;
    }

    public int getDOESize() {
        return DOESize;
    }

    public int getGenSize() {
        return genSize;
    }

    @Override
    public String toString() {
        return "Scheduler(DOESize: " + DOESize + ", genSize: " + genSize + ")";
    }

    public void setDOESize(int DOESize) {
        this.DOESize = DOESize;
    }

    public void setGenSize(int genSize) {
        this.genSize = genSize;
    }

    /** Minimum size for the DOE: the logic here is to return the minimum value between 2*nInp (suggested value for MOGA) and nVal/50 (suggested
     * value considering maximized the number of generations). The result is than compared to a given threshold (to
     * grant meaningful generations)
     *
     * @param nVal - number of evaluations requested to the scheduler
     * @param nInp - number of input variables in the workflow
     * @param nOut - number of the objectives in the workflow
     * @return
     */
    public static int minDOEsize (int nVal, int nInp, int nOut) {
        return Math.max(5, Math.min(nVal/50, 2*nInp));
    }

    /** Maximum size for the DOE: the logic here is to return the maximum value between 2*nInp*nOut (suggested value for MOGA) and nVal/10 (suggested
     * value considering minimized the number of generations). The result is than compared to a given threshold (to
     * grant meaningful generations)
     *
     * @param nVal - number of evaluations requested to the scheduler
     * @param nInp - number of input variables in the workflow
     * @param nOut - number of the objectives in the workflow
     * @return
     */
    public static int maxDOEsize (int nVal, int nInp, int nOut) {
        return Math.min(100, Math.max(nVal / 10, 2 * nInp * nOut));
    }


}
