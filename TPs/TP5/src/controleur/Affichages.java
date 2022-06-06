package controleur;

public class Affichages {

    /**
     * Méthode pour afficher le menu principale
     * @return ==> Cette méthode retourne le numéro choisi par l'utilisateur
     */
    public static int menuPrincipal(){
        System.out.print("\n===== HELLO WORLD =====");
        System.out.print("\n1 - Créer un compte");
        System.out.print("\n2 - Afficher un compte");
        System.out.print("\n3 - Créer une ligne comptable");
        System.out.print("\n4 - Quitter\n");
        return Interactions.lireUnEntier(1,4);
    }

    /**
     * Méthode pour afficher le type de compte
     * @return ==> Cette méthode retourne le numéro choisi par l'utilisateur
     */
    public static int chooseAccTypeFirst(){
        System.out.print("\n==> Choisir le type de compte");
        System.out.print("\n1 - Epargne");
        System.out.print("\n2 - Autre\n");
        return Interactions.lireUnEntier(1,2);
    }

    /**
     * Méthode pour afficher les autres types de compte
     * @return ==> Cette méthode retourne le numéro choisi par l'utilisateur
     */
    public static int chooseAccType(){
        System.out.print("\n==> Choisir le type de compte");
        System.out.print("\n0 - Courant");
        System.out.print("\n1 - Joint\n");
        return Interactions.lireUnEntier(0,1);
    }

    /**
     * Méthode pour choisir le modif de la ligne
     * @return ==> Cette méthode retourne le numéro choisi par l'utilisateur
     */
    public static int chooseMotif(){
        System.out.print("\n==> Choisir le motif");
        System.out.print("\n0 - Salaire");
        System.out.print("\n1 - Loyer");
        System.out.print("\n2 - Alimentation");
        System.out.print("\n3 - Divers\n");
        return Interactions.lireUnEntier(0,3);
    }

    /**
     * Méthode pour choisir le moyen de paiement
     * @return ==> Cette méthode retourne le numéro choisi par l'utilisateur
     */
    public static int choosePaiement(){
        System.out.print("\n==> Choisir le motif");
        System.out.print("\n0 - CB");
        System.out.print("\n1 - Cheque");
        System.out.print("\n2 - Virement\n");
        return Interactions.lireUnEntier(0,2);
    }
}
