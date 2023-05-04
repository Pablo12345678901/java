public class B_plusieurs_class_en_un_fichier {
    public static void main(String[] args) {
        Point a = new Point() ;
        a.initialise(12, 23);
        a.affiche();
        a.deplace(-3, 32);
        a.affiche() ;
        System.out.println("Fin du programme.") ;
    }
}

class Point{
    public void initialise (int abs, int ord)
    {   x = abs ;
        y = ord ;
    }
    public void deplace (int dx, int dy)
    {   x+=dx ;
        y+=dy ;
    }
    public void affiche()
    { System.out.println("Le point est en x y " + x + " " + y ) ;
    }
    private int x ;
    private int y ;
}