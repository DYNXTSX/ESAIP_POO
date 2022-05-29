import java.util.LinkedList;

public class main {
    public static void main(String[] args){
        LinkedList<Point> courbe = new LinkedList<>();

        Point p1 = new Point(0,0);
        Point p2 = new Point(2,0);
        Point p3 = new Point(3,1);

        courbe.add(p1);
        courbe.add(p2);
        courbe.add(p3);

        for (int i=0;i<courbe.size(); i++){
            Point p = courbe.get(i);
            p.affiche();
        }



    }
}
