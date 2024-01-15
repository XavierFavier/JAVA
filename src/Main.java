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
    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false; // Negative numbers are not perfect squares
        }

        int sqrt = (int) Math.sqrt(num); // Calculate the integer square root

        // Check if the square of the integer square root is equal to the original number
        return sqrt * sqrt == num;
    }
    static int small_square(int x) {
        while(true) {
            x++;
            if(isPerfectSquare(x)) {
                return x;
            }
        }
    }
    static int big_square(int x) {
        while(true) {
            x--; //diff. here
            if(isPerfectSquare(x)) {
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

    static String decrypt(String myStr) {
        return myStr.replace(String.valueOf("0"), "");
    }

    public static void main(String[] args) {
        //2A.1
        //enumerate_while(100);
        //enumerate_for(100);
        //enumerate_even(100);

        //2A.2
        System.out.println(small_square(63));
        System.out.println(small_square(30));
        System.out.println(small_square(36));
        System.out.println(big_square(30));
        System.out.println(big_square(63));

        //int[] myArr = fibo(10);
        //for(int i=0; i < myArr.length; i++) {
        //    System.out.println(myArr[i]);
        //}

        //double[] myArr = approximation_fibo(0.01);
        //for(int i=0; i < myArr.length; i++) {
        //    System.out.println(myArr[i]);
        //}

        //List<String> myArr = Arrays.asList("Jean", "Ahmed", "Lea", "Blanca");
        //to_upper_case(myArr);
        /*String myStr = "000T000000000000000000000000000000o0000u00000000000j0o0000000u0000000000r00s0000\n" +
                "c00o0000d00000e000000000000r000000000000000000\n" +
                "00000c0000000000o000m00000000000000m0e000 000000000s00i0000000000 0l000e00000000\n" +
                "g000000000000a00000000000000000r0s0000\n" +
                "000000000000000000000000000q00000u0000000000000000000000000i00000000\n" +
                "000f000i0ni00000r0000000a 000p00000a00000r0000000000000000000000000000000m00000000000000a000in0t000000e00n000000000i00r0000000000000000\n" +
                "00000000000v00000000000o0000000t00r0000000e000000000 0c000o00d000000000e000000000\n" +
                "00e0000000000000000000000000000000000s0t0000000000000000000 0000000000000u0n00000\n" +
                "0000000000000000000000000000000ps00000000y000000000000000000c0h0000000op00000a0t000\n" +
                "0h0e0\n" +
                "000000000000000v00000000000i00000000000000000000000000000000000000o0000l0000en00t\n" +
                "0000000q0u000000000i 00000000sa00000it00000 000où0000000000\n" +
                "000000v0000000o0000000000u000000000000000s000000000000000000\n" +
                "00000v00000000000000i00000000v0000000000000000000000000000e0000000000z0000000\n" +
                "00(000000c0i0000000000000000000ta0ti0o00000000n 000000d000000000000000000e00\n" +
                "00J000o00000000000000h0n00 0W00o000000000000o00000000000d0000000s0000000000)0.";
        System.out.println(decrypt(myStr));*/
    }
}