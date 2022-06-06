package controleur;

import modele.Compte;
import modele.CompteEpargne;
import modele.LigneComptable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {
    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    /**
     * Méthode pour se connecter à la BDD
     * === A FAIRE AVANT ===
     * => Création BDD "esaip_poo"
     * ==> Création de l'utilisateur "root"
     * ===> Importer le fichier de configuration SQL fournit avec les TPs
     */
    public static Connection connecterDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
            String url="jdbc:mysql://localhost:3306/esaip_poo";
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

    /**
     * Méthode pour ajouter un compte dans la BDD
     * @param c => Correspond au compte qu'on ajoute
     */
    public static void AjouterCompte(Compte c){
        try{
            String query = null;
            if(c instanceof CompteEpargne)
                query="INSERT INTO compte VALUES('"+c.getType()+"',"+c.getNumero()+","+c.getSolde()+","+((CompteEpargne) c).getTaux()+")";
            else
                query="INSERT INTO compte VALUES('"+c.getType()+"',"+c.getNumero()+","+c.getSolde()+", NULL)";

            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Compte bien ajouté");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lors de l'ajout d'une ligne comptable, il est important de mettre à jours le solde du compte
     * @param c => Compte qui va voir son solde modifié
     */
    public static void MAJSolde(Compte c){
        try{
            String query = null;
            query="UPDATE compte SET solde='"+c.getSolde()+"' WHERE numero="+c.getNumero();

            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Solte à jour");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Méthode permétant d'insérer une ligne comptable dans la BDD
     * @param l => Ligne qui va être ajoutée
     */
    public static void AjouterLigneCompta(LigneComptable l){
        try{
            String query = null;
            System.out.println(l.getDate());

            query="INSERT INTO ligne VALUES("+l.getCompte().getNumero()+","+l.getSommeCrediter()+",STR_TO_DATE ('"+l.getDate()+"','%d/%m/%Y'),'"+l.getMotif()+"','"+l.getPaiement()+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Ligne bien ajouté");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lors de l'affichage d'un compte, il est important d'afficher ses lignes comptables. Pour se faire, nous devons les charger
     * @param c => Compte auquel on souhaite connaitre les lignes comptables
     */
    public static void chargerLignes(Compte c){
        try{
            cnx=connecterDB();
            st=cnx.createStatement();
            rst=st.executeQuery("SELECT * FROM ligne WHERE id_compte = "+c.getNumero()+" ORDER BY date ASC");

            while(rst.next()){
                LigneComptable l = new LigneComptable(
                        rst.getDouble("sommeCrediter"),
                        rst.getDate("date"),
                        rst.getString("motif"),
                        rst.getString("paiement")
                );

                c.ajouterLigneDansListe(l);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * Méthode permétant de récupérer un compte dans la BDD
     * @param id => Correspond à l'id du compte
     * @return => retourne le compte récupéré ou un compte null si pas trouvé
     */
    public static Compte chargerCompte(int id){
        Compte c = null;
        try{
            cnx=connecterDB();
            st=cnx.createStatement();
            rst=st.executeQuery("SELECT * FROM compte WHERE numero ="+id);

            while(rst.next()){
                if(rst.getString("type") == "Epargne") {
                    c = new CompteEpargne(
                            rst.getInt("numero"),
                            rst.getDouble("solde"),
                            rst.getDouble("taux")
                    );
                }
                else{
                    c = new Compte(
                            rst.getString("type"),
                            rst.getInt("numero"),
                            rst.getDouble("solde")
                    );
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return c;
    }
}
