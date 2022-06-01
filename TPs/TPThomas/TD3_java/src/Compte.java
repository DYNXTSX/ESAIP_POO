import java.util.Scanner;

public class Compte {
    double nomCompte;
    int valeurCrédité=0;
    String type;
    LigneComptable Compta = null;



    public double getNomCompte() {
        return nomCompte;
    }

    public void setNomCompte(double nomCompte) {
        this.nomCompte = nomCompte;
    }
    public Compte (String _type) {
        this.type = _type;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez un numéro de compte : ");
        this.nomCompte = lectureClavier.nextDouble();
    }

    public  void Affichage() {

        System.out.println("\n Votre numéro de compte est : " + nomCompte);
        System.out.println("\n La valeur crédité est : " + valeurCrédité);
    }

    public void creerligne () {
        Compta = new LigneComptable();
        valeurCrédité = valeurCrédité +Compta.LigneComptable();
    }
}
