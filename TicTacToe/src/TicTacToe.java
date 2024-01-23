public class TicTacToe extends BoardGame {
    TicTacToe() {
        setSizeLine(3);
        setSizeColumn(3);
        setCheckSize(3);

        initTable();
    }

//    //---
//    private String checkLine(String status) {
//        if(status != "") {return status;}
//        String currentRep;
//
//        for(int a=0; a < myTable.length; a++) { //for every line
//            boolean allSame = true;
//            currentRep = myTable[a][0].getRepresentation();
//
//            for(int b=0; b < myTable[a].length; b++) {
//                if(myTable[a][b].getRepresentation() != currentRep) {
//                    allSame = false;
//                }
//            }
//
//            if(allSame && currentRep != Cell.EMPTY_STR) {
//                return currentRep;
//            }
//        }
//        return "";
//    }
//    private String checkColumn(String status) {
//        if(status != "") {return status;}
//        String currentRep;
//
//        for(int b=0; b < myTable[0].length; b++) { //for every column
//            boolean allSame = true;
//            currentRep = myTable[0][b].getRepresentation();
//
//            for(int a=0; a < myTable.length; a++) {
//                if(myTable[a][b].getRepresentation() != currentRep) {
//                    allSame = false;
//                }
//            }
//
//            if(allSame && currentRep != Cell.EMPTY_STR) {
//                return currentRep;
//            }
//        }
//        return "";
//    }
//    private String checkDiagonal1(String status) {
//        if(status != "") {return status;}
//        boolean allSame = true;
//        String currentRep = myTable[0][0].getRepresentation();
//
//        for(int a=0; a < size; a++) {
//            if(myTable[a][a].getRepresentation() != currentRep) {
//                allSame = false;
//            }
//        }
//        if(allSame && currentRep != Cell.EMPTY_STR) {
//            return currentRep;
//        }
//        return "";
//    }
//    private String checkDiagonal2(String status) {
//        if(status != "") {return status;}
//        boolean allSame = true;
//        String currentRep = myTable[0][size-1].getRepresentation();
//
//        for(int a=0; a < size; a++) {
//            if(myTable[a][size-1-a].getRepresentation() != currentRep) {
//                allSame = false;
//            }
//        }
//        if(allSame && currentRep != Cell.EMPTY_STR) {
//            return currentRep;
//        }
//        return "";
//    }
//
//    @Override public boolean isOver() {
//        //notice code below works for any TicTacToe table size
//
//        String status = "";
//        //
//        status = checkLine(status);
//        status = checkColumn(status);
//        status = checkDiagonal1(status);
//        status = checkDiagonal2(status);
//
//        //-----
//        if(status.equals(player1.getRepresentation())) {
//            display();
//            view.println("Joueur 1 a gagné!");
//            return true;
//        } else if(status.equals(player2.getRepresentation())) {
//            display();
//            view.println("Joueur 2 a gagné!");
//            return true;
//        } else {
//            return allCellFilled();
//        }
//    }
}
