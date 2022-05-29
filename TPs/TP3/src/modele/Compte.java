package modele;

import controleur.Affichages;
import controleur.Interactions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Compte {
    private String type;
    private int numero;
    private double solde = 0;
    private List<String> list = Arrays.asList("Courant", "Joint");
    private LigneComptable l = null;

    public Compte(){}

    public Compte(String type, int numero, double premierVirement){
        this.type = type;
        this.numero = numero;
        this.solde = premierVirement;
    }

    public int getNumero() {
        return numero;
    }
    public String getType() {
        return type;
    }
    public double getSolde() {
        return solde;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void addSolte(double s){
        this.solde += s;
    }

    public void creerCompte(){
        int codeType = Affichages.chooseAccType();
        this.type =list.get(codeType);
        System.out.print("\n==> Quel est votre code de compte : ");
        this.numero = Interactions.lireUnEntier();
        System.out.print("\n==> Quel est le montant de votre premier virement : ");
        this.solde = Interactions.lireUnDouble();
        System.out.print("\nLe compte est bien créé !\n");
        afficherCompte();
    }

    public void creerligne() {
        l = new LigneComptable(this);
        solde = this.solde + l.creerLigneComptable();
        System.out.print("\nLe solde de votre compte est maintenant de : "+solde+"€");
    }

    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.numero +
                        "\nSolte : " + this.solde);
    }
}
