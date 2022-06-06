package modele;

import controleur.Affichages;
import controleur.Bdd;
import controleur.Interactions;

public class CompteEpargne extends Compte {
    private double taux;
    private String type;

    /*Constructeurs*/
    public CompteEpargne(){}
    public CompteEpargne(int numero, double premierVirement){
        super("Epargne", numero ,premierVirement);
        controleTaux();
    }
    public CompteEpargne(int numero, double premierVirement, double taux){
        super("Epargne", numero ,premierVirement);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void controleTaux(){
        System.out.print("\n==> Quel est le taux : ");
        double taux = Interactions.lireUnDoublePositif();
        setTaux(taux);
    }

    @Override
    public void creerCompte(){
        this.type = "Epargne";
        System.out.print("\n==> Quel est votre code de compte : ");
        this.setNumero(Interactions.lireUnEntier());
        System.out.print("\n==> Quel est le montant de votre premier virement : ");
        addSolte(Interactions.lireUnDouble());
        controleTaux();
        Bdd.AjouterCompte(this);
        System.out.print("\nLe compte est bien créé !\n");
        afficherCompte();
    }

    @Override
    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.getNumero() +
                        "\nSolde : " + this.getSolde() +
                        "\nTaux : " + this.taux);
        afficherLigneComptables();
    }
}
