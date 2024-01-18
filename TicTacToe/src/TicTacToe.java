import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TicTacToe {
    private final int size = 3;
    private Cell[][] myTable = new Cell[size][size];
    //2
    private Player player1;
    private Player player2;

    //
    private Scanner myScan = new Scanner(System.in);
    Random rand = new Random();

    //
    TicTacToe() { //constr. in Java
        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                myTable[a][b] = new Cell();
            }
        }
    }

    private void initGame() {
        System.out.println("Bienvenue dans le morpion !");

        int playerNbr = -1;
        while(playerNbr == -1) {
            System.out.print("Nombre de joueurs? 0, 1 ou 2: ");
            String playerStr = myScan.nextLine();

            try {
                playerNbr = Integer.parseInt(playerStr);
            } catch (Exception e) {
                System.out.println("Nombre incorrect. Veuillez choisir 0, 1 ou 2.");
            }

            if(playerNbr < 0  || playerNbr > 2) {
                System.out.println("Nombre incorrect. Veuillez choisir 0, 1 ou 2.");
                playerNbr = -1;
            }
        }

        if(playerNbr == 2) {
            player1 = new HumanPlayer();
            player2 = new HumanPlayer();
        } else if(playerNbr == 1) {
            player1 = new HumanPlayer();
            player2 = new ArtificialPlayer();
        } else {
            player1 = new ArtificialPlayer();
            player2 = new ArtificialPlayer();
        }
        player1.setName("Joueur 1");
        player1.setRepresentation("O");

        player2.setName("Joueur 2");
        player2.setRepresentation("X");
    }
    //3
    public void play() {
        initGame();

        //
        Player player = player1;
        while(true) {
            display();

            int[] ret = getMoveFromPlayer(player);
            setOwner(ret[0], ret[1], player);

            if(isOver()) {
                break;
            } else {
                if(player.getName().equals(player1.getName())) {
                    player = player2;
                } else {
                    player = player1;
                }
            }
        }
    }

    public void display() {
        System.out.println("-------------");
        for (int a=0; a < myTable.length; a++) { //line
            for(int b=0; b < myTable[a].length; b++) { //column
                System.out.print(myTable[a][b].getRepresentation());
            }
            System.out.println("|\n-------------");
        }
    }


    private int getLine(Player player) {
        while(true) {
            int line = -1;
            System.out.print(player.getName() + " Ligne: ");
            String lineStr = myScan.nextLine(); // Read user input

            try {
                line = Integer.parseInt(lineStr) - 1;
            } catch (Exception e) {
                System.out.println("Nombre incorrect. Veuillez choisir 1, 2 ou 3."); continue;
            }

            if(line < 0 || line >= size) {
                System.out.println("Ligne/Colonne doit être entre 1, 2 ou 3"); continue;
            }
            return line;
        }
    }

    private int getColumn(Player player) {
        while(true) {
            int column = -1;
            System.out.print(player.getName() + " Colonne: ");
            String columnStr = myScan.nextLine();

            try {
                column = Integer.parseInt(columnStr) - 1;
            } catch (Exception e) {
                System.out.println("Nombre incorrect. Veuillez choisir 1, 2 ou 3."); continue;
            }

            if (column < 0 || column >= size) {
                System.out.println("Ligne/Colonne doit être entre 1, 2 ou 3"); continue;
            }
            return column;
        }
    }

    public int[] getMoveFromPlayer(Player player) {
        if (!player.getArtificial()) {System.out.println("Veuillez rentrer un chiffre: 1, 2 ou 3");}

        while (true) {
            int line;
            int column;

            if(player.getArtificial()) {
                line = rand.nextInt(size);
                column = rand.nextInt(size);
            } else {
                line = getLine(player);
                column = getColumn(player);
            }

            //
            if (myTable[line][column].getRepresentation() != Cell.emptyStr) {
                if (!player.getArtificial()) {System.out.println("Case déjà remplie. Veuillez en choisir une autre.");}
                continue;
            }

            if(player.getArtificial()) {
                try {TimeUnit.SECONDS.sleep(2);} catch (Exception e) {} //pause 2 seconds
            }
            //all OK
            return new int[]{line, column};
        }
    }

    public void setOwner(int line, int column, Player player) {
        myTable[line][column].setRepresentation(player.getRepresentation());
    }

    //---
    private String checkLine(String status) {
        if(status != "") {return status;}
        String currentRep;

        for(int a=0; a < myTable.length; a++) { //for every line
            boolean allSame = true;
            currentRep = myTable[a][0].getRepresentation();

            for(int b=0; b < myTable[a].length; b++) {
                if(myTable[a][b].getRepresentation() != currentRep) {
                    allSame = false;
                }
            }

            if(allSame && currentRep != Cell.emptyStr) {
                return currentRep;
            }
        }
        return "";
    }
    private String checkColumn(String status) {
        if(status != "") {return status;}
        String currentRep;

        for(int b=0; b < myTable[0].length; b++) { //for every column
            boolean allSame = true;
            currentRep = myTable[0][b].getRepresentation();

            for(int a=0; a < myTable.length; a++) {
                if(myTable[a][b].getRepresentation() != currentRep) {
                    allSame = false;
                }
            }

            if(allSame && currentRep != Cell.emptyStr) {
                return currentRep;
            }
        }
        return "";
    }
    private String checkDiagonal1(String status) {
        if(status != "") {return status;}
        boolean allSame = true;
        String currentRep = myTable[0][0].getRepresentation();

        for(int a=0; a < size; a++) {
            if(myTable[a][a].getRepresentation() != currentRep) {
                allSame = false;
            }
        }
        if(allSame && currentRep != Cell.emptyStr) {
            return currentRep;
        }
        return "";
    }
    private String checkDiagonal2(String status) {
        if(status != "") {return status;}
        boolean allSame = true;
        String currentRep = myTable[0][size-1].getRepresentation();

        for(int a=0; a < size; a++) {
            if(myTable[a][size-1-a].getRepresentation() != currentRep) {
                allSame = false;
            }
        }
        if(allSame && currentRep != Cell.emptyStr) {
            return currentRep;
        }
        return "";
    }
    private boolean allCellFilled() {
        boolean allFilled = true;
        for (int a=0; a < myTable.length; a++) { //line
            for (int b = 0; b < myTable[a].length; b++) { //column
                if(myTable[a][b].getRepresentation().equals(Cell.emptyStr)) {
                    allFilled = false;
                }
            }
        }

        if(allFilled) {
            display();
            System.out.println("Egalité!");
        }

        return allFilled;
    }
    public boolean isOver() {
        //notice code below works for any TicTacToe table size

        String status = "";
        //
        status = checkLine(status);
        status = checkColumn(status);
        status = checkDiagonal1(status);
        status = checkDiagonal2(status);

        //-----
        if(status.equals(player1.getRepresentation())) {
            display();
            System.out.println("Joueur 1 a gagné!");
            return true;
        } else if(status.equals(player2.getRepresentation())) {
            display();
            System.out.println("Joueur 2 a gagné!");
            return true;
        } else {
            return allCellFilled();
        }
    }
}
