package controleur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interactions {
    private static Scanner sc = new Scanner(System.in);

    /**
     * This method is used for the input of an integer by the user between two terminals
     * @param borneMin ==> This is the minimum limit
     * @param borneMax ==> This is the maximum limit
     * @return an integer choose by the user
     */
    public static int lireUnEntier(int borneMin, int borneMax) {
        int i = 0;
        boolean continu = true;
        do {
            try {
                System.out.print("Veuillez rentrer un chiffre : ");
                i = sc.nextInt();
                continu = !((i >= borneMin)&&(i<=borneMax));
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre correct..  ");
                sc.next();
            }
        } while(continu);
        return i;
    }

    /**
     * This method is used for the input of an integer by the user
     * @return an integer choose by the user
     */
    public static int lireUnEntier() {
        int i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextInt();
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre : ");
                sc.next(); // passe l'entier pour ?viter de boucler
            }
        } while(continu);
        return i;
    }

    public static float lireUnFloat() {
        float i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextFloat();
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre : ");
                sc.next();
            }
        } while(continu);
        return i;
    }

    public static double lireUnDouble() {
        double i = 0;
        boolean continu = true;
        do {
            try {
                i = sc.nextDouble();
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre : ");
                sc.next();
            }
        } while(continu);
        return i;
    }

    public static double lireUnDoublePositif() {
        double i = -1;
        boolean continu = true;
        do {
            try {
                i = sc.nextDouble();
                if(i>=0)
                    continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre non-nul : ");
                sc.next();
            }
        } while(continu);
        return i;
    }

    public static Date lireDate() {
        boolean continu = true;
        Date date = null;
        do {
            try {
                String str = sc.nextLine();
                if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    date = f.parse(str);
                    continu = false;
                }
            } catch (ParseException e) {
                System.out.print("Erreur format ! ");
                sc.next();
            }
        } while (continu);
        return date;
    }
}
