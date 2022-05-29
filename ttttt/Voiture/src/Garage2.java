import java.util.ArrayList;
import java.util.LinkedList;

public class Garage2 {
    private String nom;
    private LinkedList<Voiture> monGarage = new LinkedList<>();

    public Garage2(String nom){
        this.nom = nom;
    }

    public void afficher(){
        for(int i=0; i < monGarage.size(); i++)
            monGarage.get(i).afficher();
    }

    public void ajouter(Voiture v){
        monGarage.add(v);
    }

    public void supprimer(int i){
        monGarage.remove(i);
    }
}
