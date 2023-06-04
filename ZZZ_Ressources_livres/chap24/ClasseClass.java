package zzz_ressources_livres.chap24;
public class ClasseClass 
{ public static void main (String args[]) 
  { Point p = new Point() ;
    Class<?> c = p.getClass() ; // ou c = Point.class ; 
    System.out.println ("classe de c = " + c.getName()) ;  
     // affichage de la conversion de c en String (m�tode toString)
    System.out.println ("classe de c (obtenue par toString) = " + c) ;
    
    Couple<Point> cp = new Couple<Point>() ;
    Couple <?> cj = new Couple<Point>() ;
    System.out.println ("classe Couple<Point> = " + cp.getClass().getName()) ;
    System.out.println ("classe Couple<?> = " + cj.getClass().getName()) ;
  }
}
class Point
{ private int x, y ;
}
class Couple<T>
{ private T x, y ;
}