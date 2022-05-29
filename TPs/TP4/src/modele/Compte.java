package modele;

import controleur.Affichages;
import controleur.Interactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Compte implements Comparable{
    private String type;
    private int numero;
    private double premierVirement;
    private double valeurCourante;
    private List<String> list = Arrays.asList("Courant", "Joint");
    private ArrayList<LigneComptable> mesLignes = new ArrayList<LigneComptable>();

    public Compte(){}

    public Compte(String type, int numero, double premierVirement){
        this.type = type;
        this.numero = numero;
        this.premierVirement = premierVirement;
        this.valeurCourante += premierVirement;
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

    public void creerLigneComptable(){
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
        this.valeurCourante += l.getSommeCrediter();
        insert(l);
    }

    public void insert(LigneComptable l)
    {
        mesLignes.add(l);
    }

    public void afficherCompte(){
        System.out.println(
                "Type de compte : " + this.type +
                        "\nNuméro de compte : " + this.numero +
                        "\nPremière valeur : " + this.premierVirement);
        System.out.println("==> Les lignes comptables");
        for (LigneComptable mesLigne : mesLignes) mesLigne.afficherLigne();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
