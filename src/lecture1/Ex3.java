package lecture1;

/**
 * Exercise on if and switch structures
 */
public class Ex3 {

    public static void main(String[] args){
        System.out.println("Check on if structure");
        boolean knowIfStructure = true;
        if (knowIfStructure)
            System.out.println("Done!");
        else {
            System.out.println("Study the slides");
            System.out.println("Retry!");
        }

        ////////////////////////////////////////////////////////////////////

        System.out.println("Check on switch structure");        //let's try to write down a function for the number of days in a month

        boolean leap = true;
        for (int i=0; i<14; i++ ){
            System.out.println("Number of days in "+nameOfMonth(i)+" is "+daysInMonth(i, leap));
        }

        String[] year = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        System.out.println("\nSecond check on array");
        for (int i=0; i<12; i++ ){
            System.out.println("Number of days in "+year[i]+" is "+daysInMonth(i+1, leap));
        }


    }

    public static int daysInMonth(int nMonth, boolean leapYear) {
        /**
         * Use switch structure to assign the number of days to a month
         */
        if ((nMonth<1) || (nMonth>12)) {
            return 0;
        }
        switch (nMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (leapYear)
                    return 29;
                else
                    return 28;
            default:
                return 30;
        }
    }

    public static String nameOfMonth(int nMonth) {
        switch (nMonth) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "NOT-A-MONTH";

        }

    }

}
