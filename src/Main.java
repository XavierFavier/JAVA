//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //2A
        //1.
        void test() {
            System.out.println("hello");
        }

        int i=0;
        while(i < 100) {
            i++;
            System.out.println(i);
        }

        //2.
        for(int a=0; a < 100; a++) {
            System.out.println(a+1);
        }

        //3.
        for(int a=0; a < 100; a++) {
            if((a+1) % 2 == 0) {
                System.out.println(a+1);
            }
        }
    }
}