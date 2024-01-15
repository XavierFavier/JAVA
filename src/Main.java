//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        for(int a=0; a < max; a++) {
            if((a+1) % 2 == 0) {
                System.out.println(a+1);
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

    public static void main(String[] args) {
        //2A.1
        //enumerate_while(100);
        //enumerate_for(100);
        //enumerate_even(100);

        //2A.2
        //System.out.println(small_square(30));
        System.out.println(big_square(63));
    }
}