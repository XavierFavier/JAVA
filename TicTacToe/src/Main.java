public class Main {
    public static void main(String[] args) {
        View view = new View();
        InteractionUtilisateur scanner = new InteractionUtilisateur();

        view.print("\nBienvenue dans le jeu !\n1.Morpion\n2.Puissance 4\n3.Gomoku\n\nVeuillez choisir votre jeu: ");

        int nbr = -1;
        while(nbr == -1) {
            nbr = scanner.getInt();

            if(nbr < 1  || nbr > 3) {
                view.print("Nombre incorrect. Veuillez choisir 1, 2 ou 3:");
                nbr = -1;
            }
        }

        switch(nbr) {
            case 1:
                TicTacToe ticTacToe = new TicTacToe();
                ticTacToe.play();
                break;

            case 2:
                PuissanceQ puissanceQ = new PuissanceQ();
                puissanceQ.play();
                break;

            case 3:
                Gomoku gomoku = new Gomoku();
                gomoku.play();
                break;
        }
    }
}
