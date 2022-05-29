package tests;

import modele.Compte;
import modele.LigneComptable;

import java.util.Date;

public class TestCompte {
    public static void main(String[] args){
        TestCompte testCompte = new TestCompte();
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
