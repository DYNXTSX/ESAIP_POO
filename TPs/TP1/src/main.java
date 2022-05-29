import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class main {
    public static void main(String[] args){
        int codeMenu = 0;
        while (codeMenu != 4){
            codeMenu = menuPrincipal();
            switch(codeMenu){
                case 1:
                    creerCompte();
                    break;

                case 2 :
                    afficherCompte();
                    break;

                case 3 :
                    createLine();
                    break;
            }
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static int codeCompte;
    private static String codeType;
    private static float premiereValeur;
    private static float tauxDePlacement = 0;
    public static void creerCompte(){
        List<String> list = Arrays.asList("Courant", "Joint", "Epargne");
        System.out.println("=> Création compte");
        codeType = list.get(chooseAccType());
        System.out.println("\n=> Code de compte");
        codeCompte = lireUnEntier();
        System.out.println("\n=> Première valeur à crédider");
        premiereValeur = lireUnFloat();
        tauxDePlacement = 0;
        if(codeType== list.get(2)){
            System.out.println("=> Taux de placement");
            tauxDePlacement = lireUnFloat();
        }
        afficherUnCompte((codeType), codeCompte, premiereValeur, tauxDePlacement);
    }

    public static void afficherCompte(){
        System.out.println("\n=> Affichage compte");
        int numCompte = lireUnEntier();
        if(numCompte == codeCompte){
            System.out.println(
                    "Type de compte : " + codeType +
                            "\nNuméro de compte : " + codeCompte +
                            "\nPremière valeur : " + premiereValeur +
                            "\nTaux de placement : " + tauxDePlacement);
        }else{
            System.out.println("Le compte n'existe pas !");
        }
    }

    public static void afficherUnCompte(String typeCompte, int numeroCompte, float premierVal, float tauxDePlacement){
        System.out.println("=> Affichage compte");
        int numCompte = lireUnEntier();
        if(numeroCompte == codeCompte){
            System.out.println(
                    "Type de compte : " + typeCompte +
                            "\nNuméro de compte : " + numeroCompte +
                            "\nPremière valeur : " + premierVal +
                            "\nTaux de placement : " + tauxDePlacement);
        }else{
            System.out.println("Le compte n'existe pas !");
        }
    }

    public static void createLine(){
        List<String> motifsList = Arrays.asList("Salaire", "Loyer", "Alimentation", "Divers");
        List<String> paiementList = Arrays.asList("CB", "Cheque", "Virement");
        System.out.println("createAcc");

        int codeCompte = lireUnEntier();
        /*
        Boucle afin de verifier si le numéro correspong à un compte
         */
        int somme = lireUnEntier();
        Date date = lireDate();
        int motif = chooseMotif();
        int paiement = choosePaiement();

        System.out.println(
                "Numéro de compte : " + codeCompte +
                        "\nSomme à créditer : " + somme +
                        "\nDate de l'opération : " + date +
                        "\nMotif : " + motifsList.get(motif) +
                        "\nMode de paiement : " + paiementList.get(paiement));
    }

    public static int lireUnEntier(int borneMin, int borneMax) {
        int i = 0;
        boolean continu = true;
        do {
            try {
                System.out.print("Veuillez rentrer un chiffre : ");
                i = sc.nextInt();
                continu = !((i >= borneMin)&&(i<borneMax));
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
                System.out.print("Veuillez rentrer un chiffre : ");
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
                System.out.print("Veuillez rentrer un chiffre : ");
                i = sc.nextFloat();
                continu = false;
            } catch (InputMismatchException e) {
                System.out.print("Veuillez rentrer un chiffre : ");
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
                System.out.println("Saisissez une date (JJ/MM/AAAA) :");
                String str = sc.nextLine();
                if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                    SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
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

    public static int menuPrincipal(){
        System.out.print("\n===== HELLO WORLD =====");
        System.out.print("\n1 - Créer un compte");
        System.out.print("\n2 - Afficher un compte");
        System.out.print("\n3 - Créer une ligne comptable");
        System.out.print("\n4 - Quitter\n");
        return lireUnEntier(1,4);
    }

    public static int chooseAccType(){
        System.out.print("\n==> Choisir le type de compte");
        System.out.print("\n0 - Courant");
        System.out.print("\n1 - Joint");
        System.out.print("\n2 - Epargne");
        return lireUnEntier(0,2);
    }

    public static int chooseMotif(){
        System.out.print("\n==> Choisir le motif");
        System.out.print("\n0 - Salaire");
        System.out.print("\n1 - Loyer");
        System.out.print("\n2 - Alimentation");
        System.out.print("\n3 - Divers");
        return lireUnEntier(0,3);
    }

    public static int choosePaiement(){
        System.out.print("\n==> Choisir le motif");
        System.out.print("\n0 - CB");
        System.out.print("\n1 - Cheque");
        System.out.print("\n2 - Virement");
        return lireUnEntier(0,2);
    }

}
