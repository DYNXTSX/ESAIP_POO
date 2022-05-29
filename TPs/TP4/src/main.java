import controleur.*;
import modele.Compte;
import modele.CompteEpargne;
import modele.LigneComptable;
import sun.security.util.ArrayUtil;

import java.util.*;

public class main {

    private static Compte c;
    private static LigneComptable l = new LigneComptable();
    private static Compte[] mesComptes;

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
                addCompte(c);
                tri_bulle(mesComptes);
                break;
            case 2:
                System.out.println("Compte");
                c = new Compte();
                c.creerCompte();
                addCompte(c);
                tri_bulle(mesComptes);
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
        c.creerLigneComptable();
    }

    public static void addCompte(Compte c)
    {
        //turn array into ArrayList using asList() method
        List arrList = new ArrayList( Arrays.asList(mesComptes));
        // adding a new element to the array
        arrList.add(c);
        // Transforming the ArrayList into an array
        mesComptes = (Compte[]) arrList.toArray(mesComptes);
    }

    static void tri_bulle(Compte[] tab)
    {
        int taille = tab.length;
        Compte tmp = null;
        for(int i=0; i < taille; i++)
        {
            for(int j=1; j < (taille-i); j++)
            {
                if(tab[j-1].getNumero() > tab[j].getNumero())
                {
                    //echanges des elements
                    tmp = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = tmp;
                }

            }
        }
    }

}
