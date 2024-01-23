import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class BoardGame {
    protected int sizeLine = 0;
    void setSizeLine(int input) {
        sizeLine = input;
    }

    protected int sizeColumn = 0;
    void setSizeColumn(int input) {
        sizeColumn = input;
    }

    protected Cell[][] myTable;
    //2
    protected Player player1;
    protected Player player2;

    //
    Random rand = new Random();

    protected View view = new View();
    protected InteractionUtilisateur myScan = new InteractionUtilisateur();

    protected boolean puissanceBool = false;
    protected void setPuissance(boolean input) {
        puissanceBool = input;
    }

    //
    public BoardGame() { //constr. in Java

    }

    protected void initTable() {
        myTable = new Cell[sizeLine][sizeColumn];

        for (int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable[a].length; b++) {
                myTable[a][b] = new Cell();
            }
        }
    }

    private void initGame() {
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

    public void setOwner(int line, int column, Player player) { //overriden for PuissanceQ
        myTable[line][column].setRepresentation(player.getRepresentation());
    }

    private int getLine(Player player) {
        while(true) {
            int line = -1;
            view.print(player.getName() + " Ligne: ");
            line = myScan.getInt()-1; // Read user input

            if(line < 0 || line >= sizeLine) {
                view.println("Ligne/Colonne doit être entre 1 et " + String.valueOf(sizeLine)); continue;
            }
            return line;
        }
    }

    private int getColumn(Player player) {
        while(true) {
            int column = -1;
            view.print(player.getName() + " Colonne: ");
            column = myScan.getInt()-1;

            if (column < 0 || column >= sizeColumn) {
                view.println("Ligne/Colonne doit être entre 1 et " + String.valueOf(sizeColumn)); continue;
            }
            return column;
        }
    }

    private int puissanceQ_util(int column) { //returns line
        for(int a=myTable.length-1; a >= 0; a--) {
            if(myTable[a][column].getRepresentation() == Cell.EMPTY_STR) {
                return a;
            }
        }

        return -1;
    }

    public int[] getMoveFromPlayer(Player player) {
        if (!player.getArtificial()) {view.println("Veuillez rentrer un nombre:");}

        while (true) {
            int line;
            int column;

            if(puissanceBool) {
                if(player.getArtificial()) {
                    column = rand.nextInt(sizeLine);
                } else {
                    column = getColumn(player);
                }
                line = puissanceQ_util(column);

                if(line == -1) {
                    view.println("Colonne complète. Veuillez en choisir une autre.");
                    continue;
                }
            } else {
                if(player.getArtificial()) {
                    line = rand.nextInt(sizeLine);
                    column = rand.nextInt(sizeColumn);
                } else {
                    line = getLine(player);
                    column = getColumn(player);
                }
            }

            //
            if (myTable[line][column].getRepresentation() != Cell.EMPTY_STR) {
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
                if(myTable[a][b].getRepresentation().equals(Cell.EMPTY_STR)) {
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
        view.println("");
        view.println("");
        for(int a=0; a < sizeColumn; a++) {
            view.print("----");
        }
        view.print("\n");
        for (int a=0; a < myTable.length; a++) { //line
            for(int b=0; b < myTable[a].length; b++) { //column
                view.print(myTable[a][b].getRepresentation());
            }
            view.println("|");
            for(int c=0; c < sizeColumn; c++) {
                view.print("----");
            }
            view.print("\n");
        }
    }

    private boolean isOver_util(boolean same, String curStr) {
        if(same && curStr != Cell.EMPTY_STR) {
            if(curStr.equals(player1.getRepresentation())) {
                display();
                view.println("Joueur 1 a gagné!");
                return true;
            } else if(curStr.equals(player2.getRepresentation())) {
                display();
                view.println("Joueur 2 a gagné!");
                return true;
            }
        }
        return false;
    }
    //
    protected int checkSize = 0;
    void setCheckSize(int input) {
        checkSize = input;
    }

    protected boolean isOver() {
        for(int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable.length; b++) { //for every cell
                //line
                boolean same = true;
                String curStr = myTable[a][b].getRepresentation();
                if(b+checkSize <= myTable[a].length) {
                    for(int c=0; c < checkSize; c++) {
                        if(myTable[a][b+c].getRepresentation() != curStr) {
                            same = false;
                        }
                    }
                    if(isOver_util(same, curStr)) {return true;}
                }

                //column
                same = true;
                curStr = myTable[a][b].getRepresentation();
                if(a+checkSize <= myTable.length) {
                    for (int c=0; c < checkSize; c++) {
                        if (myTable[a+c][b].getRepresentation() != curStr) {
                            same = false;
                        }
                    }
                    if(isOver_util(same, curStr)) {return true;}
                }

                //diagonal1
                same = true;
                curStr = myTable[a][b].getRepresentation();
                if(b+checkSize <= myTable[a].length &&
                        a+checkSize <= myTable.length) {

                    for(int c=0; c < checkSize; c++) {
                        if(myTable[a+c][b+c].getRepresentation() != curStr) {
                            same = false;
                        }
                    }
                    if(isOver_util(same, curStr)) {return true;}
                }

                //diagonal2
                same = true;
                curStr = myTable[a][b].getRepresentation();
                if(b+checkSize <= myTable[a].length &&
                        a-checkSize >= -1) {

                    for(int c=0; c < checkSize; c++) {
                        if(myTable[a-c][b+c].getRepresentation() != curStr) {
                            same = false;
                        }
                    }
                    if(isOver_util(same, curStr)) {return true;}
                }
            }
        }

        return allCellFilled();
    }
}
