// ci-dessous référence à une méthode associée à un objet (fourni implicitement avec le this)
interface DistanciableDe { public int distance_a (Point p) ; }
// ci-dessous methode de class dont les objets sont fournis explicitement
interface Distanciable { public int distance (Point p1, Point p2 ) ; }

public class C_reference_a_methode_dun_objet
{   public static void main (String [] args)
    {   Point p1 = new Point (1, 3) ;
        Point p2 = new Point (3, 8) ;
        Point origine = new Point (0, 0) ;
        Point p = new Point (1, 2) ;
        DistanciableDe distOrig = origine::distance_a ;  
        // equivalent a :    distOrig = pp -> origine.distance_a (pp) ;
        System.out.println ("Distance de p1 a origine = " + distOrig.distance_a(p1)) ;
        DistanciableDe dist_p = p::distance_a ;
        // equivalent a :    dist_p = pp -> p.distance_a (pp) ;   
        System.out.println ("Distance de p2 a p =       " + dist_p.distance_a(p2)) ;

        Distanciable dist_XXX = Point::distance_a ;
        System.out.println ("Distance de p2 a origi =   " + dist_XXX.distance(p2, origine)) ;
    }
}
class Point
{ public Point (int x, int y ) { this.x = x ; this.y = y ; }
  public int distance_a (Point p) { return p.x - x ; }
  private int x, y ;
}
