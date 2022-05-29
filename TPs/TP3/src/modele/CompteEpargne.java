package modele;

import controleur.Affichages;
import controleur.Interactions;

public class CompteEpargne extends Compte {
    private double taux;
    private String type;
    private int numero;
    private double premierVirement;

    public CompteEpargne(){}
    public CompteEpargne(int numero, double premierVirement){
        super("Epargne", numero ,premierVirement);
        controleTaux();
    }

    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    public void controleTaux(){
        System.out.print("\n==> Quel est le taux : ");
        double taux = Interactions.lireUnDouble();
        setTaux(taux);
    }

    @Override
    public Compte creerCompte(){
        this.type = "Epargne";
        System.out.print("\n==> Quel est votre code de compte : ");
        this.numero = Interactions.lireUnEntier();
        System.out.print("\n==> Quel est le montant de votre premier virement : ");
        this.premierVirement = Interactions.lireUnDouble();
        controleTaux();
        System.out.print("\nLe compte est bien créé !\n");
        afficherCompte();
        return this;
    }

    @Override
    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.numero +
                        "\nPremière valeur : " + this.premierVirement +
                        "\nTaux : " + this.taux);
    }
}
