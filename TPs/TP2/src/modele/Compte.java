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
    private double taux=0;
    private List<String> list = Arrays.asList("Courant", "Joint", "Epargne");

    public Compte(){}

    public Compte(String type, int numero, double premierVirement, double taux){
        this.type = type;
        this.numero = numero;
        this.premierVirement = premierVirement;
        this.taux = taux;
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
    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        if(this.type == "Epargne"){
            this.taux = taux;
        }
    }

    public Compte creerCompte(){
        int codeType = Affichages.chooseAccType();
        this.type =list.get(codeType);
        System.out.print("\n==> Quel est votre code de compte : ");
        this.numero = Interactions.lireUnEntier();
        System.out.print("\n==> Quel est le montant de votre premier virement : ");
        this.premierVirement = Interactions.lireUnDouble();
        if(codeType==2){
            System.out.print("\n==> Quel est votre taux : ");
            this.taux = Interactions.lireUnDouble();
        }
        System.out.print("\nLe compte est bien créé !\n");
        afficherCompte();
        return this;
    }

    public LigneComptable creerLigneComptable(){
        System.out.print("\nLe numéro de compte est : "+this.numero);
        System.out.print("\nQuel est la somme : ");
        LigneComptable l = new LigneComptable();
        l.setSommeCrediter(Interactions.lireUnDouble());
        System.out.print("\nQuel est la date (type : jj/mm/aaaa) : ");
        l.setDate(Interactions.lireDate());
        int motif = Affichages.chooseMotif();
        l.setMotif(l.getMotifsList().get(motif));
        int paiement = Affichages.choosePaiement();
        l.setPaiement(l.getPaiementList().get(paiement));
        System.out.print("\nLa ligne comptable est bien créé !\n");
        return l;
    }


    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.numero +
                        "\nPremière valeur : " + this.premierVirement +
                        "\nTaux de placement : " + this.taux);
    }
}
