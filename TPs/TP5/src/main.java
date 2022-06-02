import controleur.*;
import modele.Compte;
import modele.CompteEpargne;
import modele.LigneComptable;

import java.sql.Connection;
import java.util.*;

public class main {

    private ArrayList<Compte> mesComptes = new ArrayList<Compte>();
    static Connection cnx;

    public void main(String[] args){
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

    private Scanner sc = new Scanner(System.in);

    public void creerCompte(){
        System.out.println("=> Création de compte");
        int sousMenu = Affichages.chooseAccTypeFirst();
        switch(sousMenu){
            case 1 :
                System.out.println("Compte Epargne");
                Compte ce = new CompteEpargne();
                ce.creerCompte();
                mesComptes.add(ce);
                break;
            case 2:
                System.out.println("Compte");
                Compte c = new Compte();
                c.creerCompte();
                mesComptes.add(c);
                break;
        }
    }

    public void afficherCompte(){
        int codeErreur = 1;
        System.out.print("\n=> Afficher le compte");
        System.out.print("\nRenseigner votre numéro de compte : ");
        int numCompte = Interactions.lireUnEntier();
        for (Compte compte : mesComptes) {
            if(compte.getNumero() == numCompte){
                compte.afficherCompte();
                codeErreur = 0;
                break;
            }
        }
        if(codeErreur == 1)
            System.out.println("Numéro de compte inconnu...");
    }

    public void createLine(){
        int codeErreur = 1;
        System.out.print("\n=> Créer une ligne comptage");
        System.out.print("\nRenseigner votre numéro de compte : ");
        int numCompte = Interactions.lireUnEntier();
        for (Compte compte : mesComptes) {
            if(compte.getNumero() == numCompte){
                compte.creerligne();
                codeErreur = 0;
                break;
            }
        }
        if(codeErreur == 1)
            System.out.println("Numéro de compte inconnu...");
    }

    public void ajouterCompteDansListe(Compte c){
        mesComptes.add(c);
        Collections.sort(mesComptes);
    }

    public void tri_bulle(ArrayList<Compte> tab) {
        int taille = tab.size();
        Compte tmp = null;
        for(int i=0; i < taille; i++) {
            for(int j=1; j < (taille-i); j++) {
                if(tab.get(j - 1).getNumero() > tab.get(j).getNumero()) {
                    //echanges des elements
                    tmp = tab.get(j - 1);
                    tab.set(j - 1, tab.get(j));
                    tab.set(j, tmp);
                }
            }
        }
    }
}
