import java.util.Scanner;

public class CpteEpargne extends Compte {
    int taux=0;
    Scanner lectureClavier = new Scanner(System.in);

    public CpteEpargne(String _type){
        super(_type);
        System.out.println("Vous avez choisi un compte épargne");
        contrôleTaux();
    }


        private void contrôleTaux ( ) {
        System.out.println("Entrez un taux :");
        taux = lectureClavier.nextInt();

        if (taux <= 0) {
            System.out.println("Impossible, entrer un nouveau taux.");
            taux = lectureClavier.nextInt();
            System.out.println("Votre taux est : "+ taux);
        }
        else {
            System.out.println("Taux validé");
        }
    }


        public void Affichage () {

           super.Affichage();
            System.out.println("Votre taux est : "+taux);


        }

    }


