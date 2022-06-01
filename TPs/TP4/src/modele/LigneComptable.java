package modele;

import controleur.Affichages;
import controleur.Interactions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LigneComptable {
    private List<String> motifsList = Arrays.asList("Salaire", "Loyer", "Alimentation", "Divers");
    private List<String> paiementList = Arrays.asList("CB", "Cheque", "Virement");

    private double sommeCrediter;
    private Compte compteAssoce = null;
    private Date date;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String motif;
    private String paiement;

    public LigneComptable(Compte c){
        this.compteAssoce = c;
    }

    public LigneComptable(double sommeCrediter, Date date, String motif, String paiement){
        this.sommeCrediter = sommeCrediter;
        this.date = date;
        this.motif = motif;
        this.paiement = paiement;
    }

    public void afficherLigne(){
        System.out.println(
                        "Somme crédité : " + this.sommeCrediter +
                        "\nDate : " + dateFormat.format(this.date) +
                        "\nMotif : " + this.paiement +
                        "\nMoyen de paiement : " + this.paiement+
                        "\n===============");
    }

    public double  creerLigneComptable(){
        System.out.print("\nQuel est la somme : ");
        sommeCrediter = Interactions.lireUnDouble();
        System.out.print("\nQuel est la date (type : jj/mm/aaaa) : ");
        setDate(Interactions.lireDate());
        int motif = Affichages.chooseMotif();
        setMotif(getMotifsList().get(motif));
        int paiement = Affichages.choosePaiement();
        setPaiement(getPaiementList().get(paiement));
        System.out.print("\nLa ligne comptable est bien créé !\n");
        afficherLigne();
        return sommeCrediter;
    }

    public String getMotif() {
        return motif;
    }

    public Date getDate() {
        return date;
    }

    public Compte getCompte() {
        return compteAssoce;
    }

    public int getNumeroCompte() {
        return compteAssoce.getNumero();
    }

    public double getSommeCrediter() {
        return sommeCrediter;
    }

    public List<String> getMotifsList() {
        return motifsList;
    }

    public List<String> getPaiementList() {
        return paiementList;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setCompte(Compte compte) {
        this.compteAssoce = compte;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setMotifsList(List<String> motifsList) {
        this.motifsList = motifsList;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public void setPaiementList(List<String> paiementList) {
        this.paiementList = paiementList;
    }

    public void setSommeCrediter(double sommeCrediter) {
        this.sommeCrediter = sommeCrediter;
    }



}
