public class Voiture {
    private String nom;

    public Voiture(String nom){
        this.nom = nom;
    }

    public void afficher(){
        System.out.println("Voiture : " + nom);
    }
}
