package tests;

import modele.Compte;
import modele.LigneComptable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCompte {
    public static void main(String[] args) throws ParseException {
        TestCompte testCompte = new TestCompte();
        test1();
    }

    public static void test1() throws ParseException {
        System.out.println("TEST AJOUT COMPTE EN BDD + LIGNE COMPTABLES");
        Compte leCompte = new Compte("Courant", 6, 10.6);
        System.out.println("=> Compta avec 10.6 €");
        leCompte.ajoutCompteBdd();
        //Ligne comptable n°1
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = f.parse("01/03/2001");
        leCompte.creerligneTest(10,date, "Salaire", "CB");
        System.out.println("=> Création d'une ligne comptable ajoutant  10€");
        System.out.println("=> Vérification en BDD que le nouveau solde est bien de 20.6 €");


    }
}
