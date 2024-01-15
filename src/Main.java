//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Vector;
import java.util.List;
import java.util.Arrays;

public class Main {
    //2A.1
    static void enumerate_while(int max) {
        //1.
        int i=0;
        while(i < max) {
            i++;
            System.out.println(i);
        }
    }
    static void enumerate_for(int max) {
        //2.
        for(int a=0; a < max; a++) {
            System.out.println(a+1);
        }
    }
    static void enumerate_even(int max) {
        //3.
        for(int a=0; a < max+1; a++) {
            if(a%2 == 0) {
                System.out.println(a);
            }
        }
    }

    //2A.2
    static int small_square(int x) {
        while(true) {
            x++;

            double sqrt = Math.sqrt(x);
            long sqrt2 = Math.round(sqrt);
            if (Math.abs(sqrt - sqrt2) / sqrt < 1e-15) {
                return x;
            }
        }
    }
    static int big_square(int x) {
        while(true) {
            x--; //diff. here

            double sqrt = Math.sqrt(x);
            long sqrt2 = Math.round(sqrt);
            if (Math.abs(sqrt - sqrt2) / sqrt < 1e-15) {
                return x;
            }
        }
    }

    static int[] fibo(int x) {
        Vector<Integer> myVect = new Vector<Integer>();

        if(x > 0) {
            myVect.add(0);
        }
        if(x > 1) {
            myVect.add(1);
        }

        for(int i=2; i < x; i++) {
            myVect.add(myVect.getLast() + myVect.get(myVect.size()-2));
        }

        int[] myArr = new int[myVect.size()];
        for(int i=0; i < myVect.size(); i++) {
            myArr[i] = myVect.get(i);
        }

        return myArr;
    }

    static double[] approximation_fibo(double x) {
        double a=2;
        double b=1;
        double c=1;

        int i=0;
        while(i < 100) {
            if(Math.abs(a/b-1.6180333) <= x) {
                double[] ans = new double[2];
                ans[0] = a;
                ans[1] = b;
                return ans;
            } else {
                c=b;
                b=a;
                a=b+c;
            }
            i++;
        }
        double[] ans = new double[2];
        return ans;
    }

    static void describe(List<String> myArr) {
        //1.
        /*for(int i=0; i < myArr.size(); i++) {
            String myStr = myArr.get(i);
            System.out.println(myStr + ": " + myStr.length());
        }

        //2.
        for(String myStr : myArr) {
            System.out.println(myStr + ": " + myStr.length());
        } */

        //3.
        /*for(String myStr : myArr) {
            if(myStr.length() >= 4) {
                System.out.println(myStr + ": " + myStr.length());
            }
        }*/
    }
    static void to_upper_case(List<String> myArr) {
        //4.
        for(String myStr : myArr) {
            System.out.println(myStr.toUpperCase());
        }
    }

    public static void main(String[] args) {
        //2A.1
        //enumerate_while(100);
        //enumerate_for(100);
        //enumerate_even(100);

        //2A.2
        //System.out.println(small_square(30));
        //System.out.println(big_square(63));

        //int[] myArr = fibo(10);
        //for(int i=0; i < myArr.length; i++) {
        //    System.out.println(myArr[i]);
        //}

        //double[] myArr = approximation_fibo(0.01);
        //for(int i=0; i < myArr.length; i++) {
        //    System.out.println(myArr[i]);
        //}

        List<String> myArr = Arrays.asList("Jean", "Ahmed", "Lea", "Blanca");
        to_upper_case(myArr);
    }
}