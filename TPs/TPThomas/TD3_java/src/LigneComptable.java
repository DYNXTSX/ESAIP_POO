import java.util.Date;
import java.util.Scanner;

public class LigneComptable {


    Compte le_compte = null;
    String Payement;
    int Somme=0;
    double nomCompte3;

    public int LigneComptable(){
        Date datedujour = new Date();
        Scanner scannerChoix = new Scanner(System.in);
        System.out.println("Entrez votre nom de compte : ");
        nomCompte3= scannerChoix.nextInt();

        System.out.println("Votre compte est valide ");
        System.out.println("Ecrivez quelle type de payement vous voulez : CB, Cheque, Viremment");
        Payement= scannerChoix.next();
        System.out.println("Vous avez choisit le mode de payement : "+ Payement);

        System.out.println("Entrez la somme que vous voulez crédité : ");
        Somme= scannerChoix.nextInt();

        System.out.println("Vous avez choisit le mode de payement : "+ Payement);
        System.out.println("La somme crédité est "+ Somme);
        System.out.println("La date est"+ datedujour);
        return Somme;



    }


}
