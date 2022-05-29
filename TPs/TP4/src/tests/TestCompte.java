package tests;

import modele.Compte;
import modele.LigneComptable;

import java.util.Date;

public class TestCompte {
    public static void main(String[] args){
        TestCompte testCompte = new TestCompte();
        Integer[] test = new Integer[10];
        test[0] = 0;
        test[1] = 1;
        test[2] = 2;
        test[3] = 3;
        test[4] = 4;
        test[5] = 5;
        test[6] = 6;
        test[7] = 7;
        test[8] = 8;
        test[9] = 9;

        for(int i=1; i<10; i++){
            test[i-1] = test[i];
        }

        for(int i=0; i<10; i++){
            System.out.println(test[i]);
        }

        //test1();
        //test2();
        //test3();
        //test4();
    }
    /*
    public static void test1(){
        System.out.println("TEST DU CONSTRUCTEUR COMPTE");
        Compte leCompte = new Compte("Courant", 6, 10.62);
        Test.test(leCompte.getNumero() == 6,"test du numéro de compte");
        Test.test(leCompte.getType().equals("Courant"),"test type de compte");
        Test.test(leCompte.getSolde() == 10.62,"test du premier virement");

    }

    public static void test2(){
        System.out.println("TEST DU CONSTRUCTEUR COMPTE PAR L'UTILISATEUR");
        Compte leCompte = new Compte();
        leCompte.creerCompte();
        leCompte.afficherCompte();
    }
     */
}
