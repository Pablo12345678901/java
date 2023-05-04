public class C_constructeur_et_copie_objet {
    public static void main(String[] args) {
        Point a = new Point(1, 2) ;
        a.affiche();
        Point b = a.copie() ;
        b.affiche();
        if (a==b) System.out.println("A " + a + " et B " + b + " ont la même valeur.") ;
        else System.out.println("A " + a + " et B " + b + " n'ont pas la même valeur.") ;
        System.out.println("Fin du programme") ;
    }
}

class Point{
    public Point (int abs, int ord)
    {   System.out.println("Constructeur") ;
        x = abs ;
        y = ord ;
    }
    public Point copie() // copie du point et retourne un nvo point identique
    {   System.out.println("Copie") ;
        Point nvo_point = new Point(x, y) ;
        //nvo_point.x = x ; nvo_point.y = y ; // inutile selon moi
        return nvo_point ;
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
