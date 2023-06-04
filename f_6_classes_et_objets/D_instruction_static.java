public class D_instruction_static {
    public static void main(String[] args) {
        Point a ;
        a = new Point() ;
        Point b = new Point() ;
        a.affiche() ;
        System.out.println("Fin du programme.") ;
    }
}

class Point 
{
    public Point()
    {   System.out.println("Constructeur") ;
        nb_pt += 1 ;
        System.out.println("Il y a désormais " + nb_pt + " points.") ;
    }
    public void affiche()
    { System.out.println("Il y a " + nb_pt + " points.") ;
    }
    static int nb_pt = 0 ;
    static {
        System.out.println("Instructions static") ;
        nb_pt = 1000000 ;
    }
}
