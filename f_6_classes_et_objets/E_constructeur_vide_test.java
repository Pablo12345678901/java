public class E_constructeur_vide_test {
    public static void main(String[] args) {
        Point a = new Point() ;
        a.affiche() ;
    }
}

class Point {
    public Point() {}
    public void affiche()
    { System.out.println("Point en x y " + x + " " + y) ;  
    }
    private int x = 0;
    private int y = 0 ;
}
