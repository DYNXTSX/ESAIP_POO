package modele;

import controleur.Affichages;
import controleur.Bdd;
import controleur.Interactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Compte implements Comparable <Compte>{
    private String type;
    private int numero;
    private double solde = 0;
    private List<String> list = Arrays.asList("Courant", "Joint");
    private ArrayList<LigneComptable> mesLignes;

    public Compte(){}

    public Compte(String type, int numero, double premierVirement){
        this.type = type;
        this.numero = numero;
        this.solde = premierVirement;
        this.mesLignes = new ArrayList<LigneComptable>();
    }

    /*GET/SET*/
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

    /**
     * Méthode pour créer un compte
     */
    public void creerCompte(){
        int codeType = Affichages.chooseAccType();
        this.type =list.get(codeType);
        System.out.print("\n==> Quel est votre code de compte : ");
        this.numero = Interactions.lireUnEntier();
        System.out.print("\n==> Quel est le montant de votre premier virement : ");
        this.solde = Interactions.lireUnDouble();
        ajoutCompteBdd();
        System.out.print("\nLe compte est bien créé !\n");
        afficherCompte();
    }

    /**
     * Méthode pour ajouter le compte dans la BDD
     */
    public void ajoutCompteBdd(){
        Bdd.AjouterCompte(this);
    }

    /**
     * Méthode pour créer une ligne comptable au compte (par l'utilisateur)
     */
    public void creerligne() {
        LigneComptable l = new LigneComptable(this);
        solde = this.solde + l.creerLigneComptable();
        ajouterLigneDansListe(l);
        l.ajoutLigneBdd();
        System.out.println("\nLe solde de votre compte est maintenant de : "+solde+"€");
    }

    /**
     * Méthode pour créer une ligen comptage (partie test)
     * @param sommeCrediter
     * @param date
     * @param motif
     * @param paiement
     */
    public void creerligneTest(double sommeCrediter, Date date, String motif, String paiement) {
        LigneComptable l = new LigneComptable(sommeCrediter, date, motif, paiement);
        l.setCompte(this);
        solde = this.solde + l.getSommeCrediter();
        ajouterLigneDansListe(l);
        Bdd.MAJSolde(this);
        l.ajoutLigneBdd();
        System.out.println("\nLe solde de votre compte est maintenant de : "+solde+"€");
    }

    /**
     * [0] ==> La plus ancienne
     * [9] ==> La plus récente
     * @param l => ligne comptable
     */
    public void ajouterLigneDansListe(LigneComptable l){
        mesLignes.add(l);
    }

    /**
     * Méthode pour afficher le compte (compte + lignes comptables)
     */
    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.numero +
                        "\nSolde : " + this.solde);
        afficherLigneComptables();
    }

    /**
     * Méthode pour afficher les lignes comptables du compte
     */
    public void afficherLigneComptables(){
        System.out.println("===============");
        System.out.println("Lignes comptables :");
        for (LigneComptable mesLigne : mesLignes) {
            mesLigne.afficherLigne();
        }
    }

    @Override
    public int compareTo(Compte o) {
        return this.getNumero() == o.getNumero() ? 1 : 0;
    }
}
