package tests;

import modele.Compte;
import modele.LigneComptable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCompte {
    public static void main(String[] args) throws ParseException {
        TestCompte testCompte = new TestCompte();
        //test1()
        test2();
    }

    public static void test1() throws ParseException {
        System.out.println("TEST DU CONSTRUCTEUR COMPTE ET UNE LIGNE COMPTABLE");
        Compte leCompte = new Compte("Courant", 6, 10.6);
        Test.test(leCompte.getNumero() == 6,"test du numéro de compte");
        Test.test(leCompte.getType().equals("Courant"),"test type de compte");
        Test.test(leCompte.getSolde() == 10.6,"test du premier virement");
        //Ligne comptable
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = f.parse("01/03/2001");
        leCompte.creerligneTest(10,date, "Salaire", "CB");
        leCompte.afficherCompte();
        Test.test(leCompte.getSolde() == 20.6,"test du nouveau solde");
    }

    public static void test2() throws ParseException {
        System.out.println("TEST DE PLUSIEURS LIGNES COMPTABLES");
        Compte leCompte = new Compte("Courant", 7, 500);
        Test.test(leCompte.getNumero() == 7,"test du numéro de compte");
        Test.test(leCompte.getSolde() == 10.6,"test du premier virement");

        //Ligne comptable n°1
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = f.parse("01/03/2001");
        leCompte.creerligneTest(10,date, "Salaire", "CB");

        //Ligne comptable n°2
        SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = f2.parse("17/06/2021");
        leCompte.creerligneTest(66.1,date2, "Loyer", "Virement");

        //Ligne comptable n°1
        SimpleDateFormat f3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date3 = f3.parse("06/06/2022");
        leCompte.creerligneTest(13.8,date3, "Divers", "CB");

        leCompte.afficherCompte();
    }
}
