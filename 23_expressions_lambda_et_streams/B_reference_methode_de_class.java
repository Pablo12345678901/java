interface Distanciable { public int distance (Point_23 p1, Point_23 p2 ) ; }

public class B_reference_methode_de_class
{   public static void main (String [] args)
    {   Point_23 p1 = new Point_23 (1, 3), p2 = new Point_23 (3, 8) ;

        Distanciable dlamb = (pp1, pp2) -> pp1.getX() - pp2.getY () ;
        
        System.out.println ("distance entre p1 et p2 =  " + dlamb.distance(p1, p2)) ;
        Distanciable d1 = Point_23::distance1 ;   // OK deux arguments type Point, retour int
        System.out.println ("distance1 entre p1 et p2 = " + d1.distance(p1, p2)) ;
        Distanciable d2 = Point_23::distance2 ;   // OK deux arguments type Point, retour int
        System.out.println ("distance2 entre p1 et p2 = " + d2.distance(p1, p2)) ;
    }
}

class Point_23
{   public Point_23 (int x, int y ) { this.x = x ; this.y = y ; }
    public int distance1 (Point_23 p) { return p.x - x ; }
    public int distance2 (Point_23 p) { return p.y - y ; }
    public int getX() { return x ; }
    public int getY() { return y ; }
    private int x, y ;
}
