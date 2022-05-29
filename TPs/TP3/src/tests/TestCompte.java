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


    public static void test1(){
        System.out.println("TEST DU CONSTRUCTEUR COMPTE");
        Compte leCompte = new Compte("Courant", 6, 10.62);
        Test.test(leCompte.getNumero() == 6,"test du numéro de compte");
        Test.test(leCompte.getType().equals("Courant"),"test type de compte");
        Test.test(leCompte.getPremierVirement() == 10.62,"test du premier virement");

    }

    public static void test2(){
        System.out.println("TEST DU CONSTRUCTEUR COMPTE PAR L'UTILISATEUR");
        Compte leCompte = new Compte();
        leCompte = leCompte.creerCompte();
        leCompte.afficherCompte();
    }

    public static void test3(){
        System.out.println("TEST DU CONSTRUCTEUR LIGNE COMPTABLE");
        LigneComptable lc = new LigneComptable(6, 1350.60, new Date(2022,2,11),"Salaire", "Virement");
        Test.test(lc.getNumeroCompte() == 6,"test du numéro de compte");
        Test.test(lc.getSommeCrediter() == 1350.60,"test de la somme créditée");
        Test.test(lc.getDate().equals(new Date(2022,2,11)),"test de la date");
        Test.test(lc.getMotif().equals("Salaire"),"test du motif");
    }

    public static void test4(){
        System.out.println("TEST DU CONSTRUCTEUR LIGNE COMPTABLE PAS L'UTILISATEUR");
        Compte leCompte = new Compte("Courant", 6, 10.62);
        LigneComptable lc = new LigneComptable();
        lc = leCompte.creerLigneComptable();
        lc.afficherLigne();
    }

}
