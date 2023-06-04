

public class A_super_objet_et_introspection
{   public static void main (String args[]) 
    {   Point p = new Point() ;
        /* Test pour voir si Class détecte la class pointcol - c'est le cas. 
        Pointcol pc = new Pointcol() ;
        p = pc ;
        */
        Class<?> c = p.getClass() ; // ou c = Point.class ; 
        System.out.println ("classe de c = " + c.getName()) ;  
        // affichage de la conversion de c en String (méthode toString)
        System.out.println ("classe de c (obtenue par toString) = " + c) ;
        
        Couple<Point> cp = new Couple<Point>() ;
        Couple <?> cj = new Couple<Point>() ;
        System.out.println ("classe Couple<Point> = " + cp.getClass().getName()) ; // identique à ci-dessous car s'efface lors de la compilation (programmation générique)
        System.out.println ("classe Couple<?> = " + cj.getClass().getName()) ;
    }
}

class Point
{   private int x, y ;
}

class Pointcol extends Point
{   private int z ;
}

class Couple<T>
{   private T x, y ;
}
