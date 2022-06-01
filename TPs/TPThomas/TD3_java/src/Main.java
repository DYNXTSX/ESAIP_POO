import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static double nomCompte2;
    static Scanner scannerAff = new Scanner(System.in);


    //menu visuel
    public static void main(String[] args) {
        Compte le_compte = null;
        String[] ChoixCompte = {"courant", "joint", "epargne"};

        int menu = 0;

        do {
            menu = menuPrincipal();
            switch (menu) {
                case 1:
                    System.out.println("Créer un compte");

                    System.out.println("Choisissez un type de compte : 0: Courant, 1: Joint , 2: Epargne");
                    int choix = scannerAff.nextInt();
                     String type = ChoixCompte[choix];


                    if (type.equals("epargne")) {
                        le_compte = new CpteEpargne(type);

                    }
                    else {
                        le_compte = new Compte(type);

                    }

                    break;

                case 2:
                    System.out.println("Afficher un compte");

                    System.out.println("Entrez votre nom de compte : ");
                    nomCompte2 = scannerAff.nextInt();


                    if (nomCompte2 == le_compte.getNomCompte()) {
                        // System.out.println("numero du compte "+nomCompte+" valeur creditée" +valeurCrédité);
                        le_compte.Affichage();
                    }
                    else {
                        System.out.println("Votre compte existe pas");
                    }
                    break;

                case 3:
                    System.out.println("Créer une ligne comptable");
                   le_compte.creerligne();
                   //LigneComptable();
                    break;

                case 4:
                    System.out.println("Sortir");
                    break;
            }
        }
        while (menu != 4);

    }

    public static int menuPrincipal(){
        System.out.print("\n===== HELLO WORLD =====");
        System.out.print("\n1 - Créer un compte");
        System.out.print("\n2 - Afficher un compte");
        System.out.print("\n3 - Créer une ligne comptable");
        System.out.print("\n4 - Quitter\n");
        return lireUnEntier(1,4);
    }

    public static int lireUnEntier(int borneMin, int borneMax) {
        Scanner lectureClavier = new Scanner(System.in);
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = lectureClavier.nextInt();
                continu = !((i >= borneMin)&&(i<=borneMax));
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre : ");
                lectureClavier.next();
            }
        } while(continu);
        return i;
    }
}
