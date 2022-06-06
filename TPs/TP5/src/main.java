import controleur.*;
import modele.Compte;
import modele.CompteEpargne;
import modele.LigneComptable;

import java.sql.Connection;
import java.util.*;

public class main {

    static Connection cnx;

    public static void main(String[] args){
        int codeMenu = 0;
        /*
        Boucle du menu
         */
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

    private Scanner sc = new Scanner(System.in);

    /**
     * Méthode qui permet la création d'un compte par l'utilisateur
     */
    public static void creerCompte(){
        System.out.println("=> Création de compte");
        int sousMenu = Affichages.chooseAccTypeFirst();
        switch(sousMenu){
            case 1 :
                System.out.println("Compte Epargne");
                Compte ce = new CompteEpargne();
                ce.creerCompte();
                break;
            case 2:
                System.out.println("Compte");
                Compte c = new Compte();
                c.creerCompte();
                break;
        }
    }

    /**
     * Méthode qui permet d'afficher un compte ci celui-ci existe
     */
    public static void afficherCompte(){
        System.out.print("\n=> Afficher le compte");
        System.out.print("\nRenseigner votre numéro de compte : ");
        int numCompte = Interactions.lireUnEntier();
        Compte c = Bdd.chargerCompte(numCompte);
        if(c != null){
            Bdd.chargerLignes(c);
            c.afficherCompte();
        }else{
            System.out.println("Numéro de compte inconnu.");
        }
    }

    /**
     * Méthode qui peremt de créer une ligne pour un compte existant
     */
    public static void createLine(){
        System.out.print("\n=> Créer une ligne comptage");
        System.out.print("\nRenseigner votre numéro de compte : ");
        int numCompte = Interactions.lireUnEntier();
        Compte c = Bdd.chargerCompte(numCompte);
        if(c != null){
            c.creerligne();
        }else{
            System.out.println("Numéro de compte inconnu.");
        }
    }


}
