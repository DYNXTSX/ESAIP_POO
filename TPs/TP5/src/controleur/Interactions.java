package controleur;

import modele.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    /* BDD */
    public static Connection connecterDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            String url="jdbc:mysql://localhost:3306/db_gstproduit";
            String user="root";
            String password="";
            Connection cnx= DriverManager.getConnection(url,user,password);
            System.out.println("Connexion bien établie");
            return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void AjouterCompte(Compte c, Connection cnx, Statement st){
        try{
            String query = null;
            if(c instanceof CompteEpargne)
                query="INSERT INTO compte VALUES("+c.getType()+",'"+c.getNumero()+"',"+c.getSolde()+","+((CompteEpargne) c).getTaux()+")";
            else
                query="INSERT INTO compte VALUES("+c.getType()+",'"+c.getNumero()+"',"+c.getSolde()+")";

            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Compte bien ajouté");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void AjouterLigneCompta(LigneComptable l, Connection cnx, Statement st){
        try{
            String query = null;
            query="INSERT INTO compte VALUES("+l.getCompte().getNumero()+","+l.getSommeCrediter()+","+l.getDate()+",'"+l.getMotif()+"','"+l.getPaiement()+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Compte bien ajouté");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void recherchePparLibelle(String libelle){
        try{
            String query="SELECT * FROM tb_produit WHERE libelle='"+libelle+"'";
            cnx=connecterDB();
            st=cnx.createStatement();
            rst= st.executeQuery(query);
            rst.last();
            int nbrRow = rst.getRow();
            if(nbrRow!=0){
                System.out.println("Produit trouve");
            }else{
                System.out.println("Produit non trouve");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }



}
