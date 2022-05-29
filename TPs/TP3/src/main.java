import controleur.*;
import modele.Compte;
import modele.CompteEpargne;
import modele.LigneComptable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {

    private static Compte c;
    private static LigneComptable l = new LigneComptable();

    public static void main(String[] args){
        int codeMenu = 0;
        while (codeMenu != 4){
            codeMenu = Affichages.menuPrincipal();
            switch(codeMenu){
                case 1:
                    creerCompte();
                    break;

                case 2 :
                    afficherCompte();
                    break;

                case 3 :
                    createLine();
                    break;
            }
        }
    }

    private static Scanner sc = new Scanner(System.in);

    public static void creerCompte(){
        System.out.println("=> Création de compte");
        int sousMenu = Affichages.chooseAccTypeFirst();
        switch(sousMenu){
            case 1 :
                System.out.println("Compte Epargne");
                c = new CompteEpargne();
                c.creerCompte();
                break;
            case 2:
                System.out.println("Compte");
                c = new Compte();
                c.creerCompte();
                break;
        }
    }

    public static void afficherCompte(){
        System.out.println(c.getNumero());
        System.out.print("\n=> Afficher le compte");
        System.out.print("\nRenseigner votre numéro de compte : ");
        int numCompte = Interactions.lireUnEntier();
        if(c.getNumero() == numCompte)
            c.afficherCompte();
        else{
            System.out.print("\nNuméro de compte inconnu...");
        }
    }

    public static void createLine(){
        System.out.print("\n=> Créer une ligne comptage");
        c.creerligne();
    }

}
