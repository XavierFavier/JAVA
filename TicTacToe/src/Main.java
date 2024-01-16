public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.display();
        ticTacToe.play();
    }
}

class Cell {
    String status = "";
    public String getRepresentation() {
        if(status == "x") {
            return "| X ";
        }
        else if(status == "o") {
            return "| O ";
        }
        else {
            return "|   ";
        }
    }
}

class TicTacToe {
    final int size = 3;
    Cell[][] myTable = new Cell[size][size];

    TicTacToe() { //constr. in Java
        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                myTable[a][b] = new Cell();
            }
        }
    }

    public void display() {
        System.out.println("-------------");
        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                System.out.print(myTable[a][b].getRepresentation());
            }
            System.out.println("|\n-------------");
        }
    }


    //2
    Player player;

    public static int[] getMoveFromPlayer() {
        int returnArr[] = new int[2];
        return returnArr;
    }

    public static void setOwner(int line, int column, Player player) {

    }

    //3
    public static void play() {

    }

    //4
    public static boolean isOver() {
        return true;
    }
}

//-----2
class Player {
    String representation = "|X ";

    public String getRepresentation() {
        return representation;
    }
}