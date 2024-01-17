public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play();
    }
}

class Cell {
    final public static String emptyStr = "|   "; //static allows us to access this without creating an object

    private String representation = emptyStr;

    public String getRepresentation() {
        return representation;
    }
    public void setRepresentation(String representationIn) {
        representation = representationIn;
    }
}

//-----2
class Player {
    private String name; //for display purposes
    private String representation;

    public String getName() {
        return name;
    }
    public void setName(String nameIn) {
        name = nameIn;
    }

    public String getRepresentation() {
        return representation;
    }
    public void setRepresentation(String representationIn) {
        representation = representationIn;
    }
}

class TicTacToe {
    private final int size = 3;
    private Cell[][] myTable = new Cell[size][size];
    //2
    private Player player1 = new Player();
    private Player player2 = new Player();

    TicTacToe() { //constr. in Java
        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                myTable[a][b] = new Cell();
            }
        }

        //
        player1.setName("Joueur 1");
        player1.setRepresentation("| O ");

        player2.setName("Joueur 2");
        player2.setRepresentation("| X ");
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
            System.out.print(player.getName() + " Ligne: ");
            String lineStr = System.console().readLine();

            System.out.print(player.getName() + " Colonne: ");
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

                if(myTable[line][column].getRepresentation() == Cell.emptyStr) {
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
        myTable[line][column].setRepresentation(player.getRepresentation());
    }

//    //4
//    private String compUtil(Cell cell1, //notice 'private' method
//                           Cell cell2,
//                           Cell cell3,
//
//                           String status) {
//
//        if(status != "") {
//            return status;
//        }
//        else if (cell1.getRepresentation() == cell2.getRepresentation() &&
//                cell2.getRepresentation() == cell3.getRepresentation() &&
//                cell1.getRepresentation() == cell3.getRepresentation() &&
//
//                cell1.getRepresentation() != Cell.emptyStr) {
//
//            return cell1.getRepresentation();
//        } else {
//            return "";
//        }
//    }
    public boolean isOver() {
        String status = "";
        for(int a=0; a < myTable.length; a++) { //for every line
            String currentRep =
            for(int b=0; b < myTable[a].length; b++) {

            }
        }

        for(int b=0; b < myTable[0].length; b++) { //for every column
            for(int a=0; a < myTable.length; a++) {

            }
        }

        //diagonal
        for(int a=0; a < size; a++) {

        }

        if(status == player1.getRepresentation()) {
            display();
            System.out.println("Joueur 1 a gagné!");
            return true;
        } else if(status == player2.getRepresentation()) {
            display();
            System.out.println("Joueur 2 a gagné!");
            return true;
        } else {
            boolean allCellFilled = true;
            for (int a=0; a < myTable.length; a++) { //line
                for (int b = 0; b < myTable[a].length; b++) { //column
                    if(myTable[a][b].getRepresentation() == Cell.emptyStr) {
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
