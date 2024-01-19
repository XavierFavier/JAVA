import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner myScan = new Scanner(System.in);

    public int getInt() { //returns -1 if error
        String result = myScan.nextLine();

        int resultInt = -1;
        try {
            resultInt = Integer.parseInt(result);
        } catch (Exception e) {

        }

        return resultInt;
    }
}
