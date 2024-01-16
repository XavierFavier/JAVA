public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play();
    }
}

class Cell {
    final static String emptyStr = "|   "; //static allows us to access this without creating an object

    String representation;
    Cell() { //constr.
        representation = emptyStr;
    }

    public String getRepresentation() {
        return representation;
    }
}

//-----2
class Player {
    String name; //for display purposes
    String representation;

    public String getRepresentation() {
        return representation;
    }
}

class TicTacToe {
    final int size = 3;
    Cell[][] myTable = new Cell[size][size];
    //2
    Player player1 = new Player();
    Player player2 = new Player();

    TicTacToe() { //constr. in Java
        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                myTable[a][b] = new Cell();
            }
        }

        //
        player1.name = "Joueur 1";
        player1.representation = "| O ";

        player2.name = "Joueur 2";
        player2.representation = "| X ";
    }
    //3
    public void play() {
        System.out.println("Bienvenue dans le morpion !");

        Player player = player1;

        boolean loopBool = true;
        while(loopBool) {
            display();

            System.out.println("Veuillez rentrer un chiffre: 1, 2 ou 3");

            int[] ret = getMoveFromPlayer(player);
            setOwner(ret[0], ret[1], player);

            if(isOver()) {
                loopBool = false;
            } else {
                if(player == player1) { //comparaison d'objets
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

    public int[] getMoveFromPlayer(Player player) {
        int line = -1;
        int column = -1;

        while(true) {
            System.out.print(player.name + " Ligne: ");
            String lineStr = System.console().readLine();

            System.out.print(player.name + " Colonne: ");
            String columnStr = System.console().readLine();

            boolean incorrectStr = false;
            try {
                line = Integer.parseInt(lineStr)-1;
            } catch(Exception e) {incorrectStr = true;}

            try {
                column = Integer.parseInt(columnStr)-1;
            } catch(Exception e) {incorrectStr = true;}


            if(incorrectStr) {
                System.out.println("Nombre incorrect. Veuillez choisir 1, 2 ou 3.");
            } else if((line == 0 || line == 1 || line == 2) &&
                    (column == 0 || column == 1 || column == 2)) {

                if(myTable[line][column].representation == Cell.emptyStr) {
                    return new int[] {line, column};
                } else {
                    System.out.println("Case déjà remplie. Veuillez en choisir une autre.");
                }
            } else {
                System.out.println("Ligne/Colonne doit être entre 1, 2 ou 3");
            }
        }
    }

    public void setOwner(int line, int column, Player player) {
        myTable[line][column].representation = player.representation;
    }

    //4
    public String compUtil(Cell cell1,
                           Cell cell2,
                           Cell cell3,

                           String status) {

        if(status != "") {
            return status;
        }
        else if (cell1.getRepresentation() == cell2.getRepresentation() &&
                cell2.getRepresentation() == cell3.getRepresentation() &&
                cell1.getRepresentation() == cell3.getRepresentation() &&

                cell1.getRepresentation() != Cell.emptyStr) {

            return cell1.getRepresentation();
        } else {
            return "";
        }
    }
    public boolean isOver() {
        String status = "";
        for(int a=0; a < myTable.length; a++) { //line
            status = compUtil(myTable[a][0], myTable[a][1], myTable[a][2], status);
        }

        for(int b=0; b < myTable[0].length; b++) { //column
            status = compUtil(myTable[0][b], myTable[1][b], myTable[2][b], status);
        }

        //diagonal
        status = compUtil(myTable[0][0], myTable[1][1], myTable[2][2], status);
        status = compUtil(myTable[2][0], myTable[1][1], myTable[0][2], status);

        if(status == player1.representation) {
            display();
            System.out.println("Joueur 1 a gagné!");
            return true;
        } else if(status == player2.representation) {
            display();
            System.out.println("Joueur 2 a gagné!");
            return true;
        } else {
            boolean allCellFilled = true;
            for (int a=0; a < myTable.length; a++) { //line
                for (int b = 0; b < myTable[a].length; b++) { //column
                    if(myTable[a][b].representation == Cell.emptyStr) {
                        allCellFilled = false;
                    }
                }
            }

            if(allCellFilled) {
                display();
                System.out.println("Egalité!");
            }

            return allCellFilled;
        }
    }
}
