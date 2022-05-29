package controleur;

public class Affichages {
    public static int menuPrincipal(){
        System.out.print("\n===== HELLO WORLD =====");
        System.out.print("\n1 - Créer un compte");
        System.out.print("\n2 - Afficher un compte");
        System.out.print("\n3 - Créer une ligne comptable");
        System.out.print("\n4 - Quitter\n");
        return Interactions.lireUnEntier(1,4);
    }

    public static int chooseAccType(){
        System.out.print("\n==> Choisir le type de compte");
        System.out.print("\n0 - Courant");
        System.out.print("\n1 - Joint");
        System.out.print("\n2 - Epargne\n");
        return Interactions.lireUnEntier(0,2);
    }

    public static int chooseMotif(){
        System.out.print("\n==> Choisir le motif");
        System.out.print("\n0 - Salaire");
        System.out.print("\n1 - Loyer");
        System.out.print("\n2 - Alimentation");
        System.out.print("\n3 - Divers\n");
        return Interactions.lireUnEntier(0,3);
    }

    public static int choosePaiement(){
        System.out.print("\n==> Choisir le motif");
        System.out.print("\n0 - CB");
        System.out.print("\n1 - Cheque");
        System.out.print("\n2 - Virement\n");
        return Interactions.lireUnEntier(0,2);
    }
}
