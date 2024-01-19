import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class BoardGame {
    protected final int size = 3;
    protected Cell[][] myTable = new Cell[size][size];
    //2
    protected Player player1;
    protected Player player2;

    //
    Random rand = new Random();

    protected View view = new View();
    protected InteractionUtilisateur myScan = new InteractionUtilisateur();

    //
    public BoardGame() { //constr. in Java
        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                myTable[a][b] = new Cell();
            }
        }
    }

    private void initGame() {
        view.println("Bienvenue dans le morpion !");

        int playerNbr = -1;
        while(playerNbr == -1) {
            view.print("Nombre de joueurs? 0, 1 ou 2: ");
            playerNbr = myScan.getInt();

            if(playerNbr < 0  || playerNbr > 2) {
                view.println("Nombre incorrect. Veuillez choisir 0, 1 ou 2.");
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

    public void setOwner(int line, int column, Player player) {
        myTable[line][column].setRepresentation(player.getRepresentation());
    }

    private int getLine(Player player) {
        while(true) {
            int line = -1;
            view.print(player.getName() + " Ligne: ");
            line = myScan.getInt()-1; // Read user input

            if(line < 0 || line >= size) {
                view.println("Ligne/Colonne doit être entre 1, 2 ou 3"); continue;
            }
            return line;
        }
    }

    private int getColumn(Player player) {
        while(true) {
            int column = -1;
            view.print(player.getName() + " Colonne: ");
            column = myScan.getInt()-1;

            if (column < 0 || column >= size) {
                view.println("Ligne/Colonne doit être entre 1, 2 ou 3"); continue;
            }
            return column;
        }
    }

    public int[] getMoveFromPlayer(Player player) {
        if (!player.getArtificial()) {view.println("Veuillez rentrer un chiffre: 1, 2 ou 3");}

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
                if (!player.getArtificial()) {view.println("Case déjà remplie. Veuillez en choisir une autre.");}
                continue;
            }

            if(player.getArtificial()) {
                try {
                    TimeUnit.SECONDS.sleep(2);} catch (Exception e) {} //pause 2 seconds
            }
            //all OK
            return new int[]{line, column};
        }
    }

    protected boolean allCellFilled() {
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
            view.println("Egalité!");
        }

        return allFilled;
    }

    public void display() {
        for(int a=0; a < size; a++) {
            view.print("----");
        }
        view.print("\n");
        for (int a=0; a < myTable.length; a++) { //line
            for(int b=0; b < myTable[a].length; b++) { //column
                view.print(myTable[a][b].getRepresentation());
            }
            view.println("|");
            for(int c=0; c < size; c++) {
                view.print("----");
            }
            view.print("\n");
        }
    }

    //
    protected boolean isOver() { //overriden for TicTacToe

        return false;
    }
}
