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
    private Date date;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String motif;
    private String paiement;

    public LigneComptable(){}

    public LigneComptable(double sommeCrediter, Date date, String motif, String paiement){
        this.sommeCrediter = sommeCrediter;
        this.date = date;
        this.motif = motif;
        this.paiement = paiement;
    }

    public void afficherLigne(){
        System.out.println(
                "Numéro de compte : " +
                        "\nSomme crédité : " + this.sommeCrediter +
                        "\nDate : " + dateFormat.format(this.date) +
                        "\nMotif : " + this.paiement +
                        "\nMoyen de paiement : " + this.paiement);
    }
    public double  creerLigneComptable(){
        System.out.print("\nQuel est la somme : ");

        sommeCrediter = Interactions.lireUnDouble();
        System.out.print("\nQuel est la date (type : jj/mm/aaaa) : ");
        l.setDate(Interactions.lireDate());
        int motif = Affichages.chooseMotif();
        l.setMotif(l.getMotifsList().get(motif));
        int paiement = Affichages.choosePaiement();
        l.setPaiement(l.getPaiementList().get(paiement));
        System.out.print("\nLa ligne comptable est bien créé !\n");
        return sommeCrediter;
    }
    public String getMotif() {
        return motif;
    }

    public Date getDate() {
        return date;
    }

    public Compte getCompte() {
        return compte;
    }

    public int getNumeroCompte() {
        return numeroCompte;
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

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
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
