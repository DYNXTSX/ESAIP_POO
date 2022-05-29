package modele;

import controleur.Affichages;
import controleur.Interactions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Compte {
    private String type;
    private int numero;
    private double premierVirement;
    private double solde =0;
    private List<String> list = Arrays.asList("Courant", "Joint");
    private LigneComptable l = null;
    public Compte(){}

    public Compte(String type, int numero, double premierVirement){
        this.type = type;
        this.numero = numero;
        this.premierVirement = premierVirement;
    }

    public int getNumero() {
        return numero;
    }
    public String getType() {
        return type;
    }
    public double getPremierVirement() {
        return premierVirement;
    }

    public Compte creerCompte(){
        int codeType = Affichages.chooseAccType();
        this.type =list.get(codeType);
        System.out.print("\n==> Quel est votre code de compte : ");
        this.numero = Interactions.lireUnEntier();
        System.out.print("\n==> Quel est le montant de votre premier virement : ");
        this.premierVirement = Interactions.lireUnDouble();
        System.out.print("\nLe compte est bien créé !\n");
        afficherCompte();
        return this;
    }

public void creerligne() {
    l = new LigneComptable();
    solde = solde +l.creerLigneComptable();
}

    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.numero +
                        "\nPremière valeur : " + this.premierVirement);
    }
}
