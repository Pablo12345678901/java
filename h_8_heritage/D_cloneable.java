public class D_cloneable {
    public static void main(String[] args) {
        System.out.println("\nPoint_cloneable : ") ;
        Point_cloneable p1 = new Point_cloneable(1, 2) ;
        p1.affiche() ;
        Point_cloneable p2 = (Point_cloneable) p1.clone() ;
        System.out.println("\nAprès clonage : ") ;
        p1.affiche() ;
        p2.affiche() ;

        System.out.println("\nPointCol_cloneable : ") ;
        PointCol_cloneable pc1 = new PointCol_cloneable(30, 40, "Jaune") ;
        pc1.affiche();
        PointCol_cloneable pc2 = (PointCol_cloneable) pc1.clone() ;
        pc1.affiche();
        pc2.affiche();
    }
}

class Point_cloneable implements Cloneable {
    Point_cloneable(int x, int y)
    {   System.out.println("Constructeur de Point_cloneable") ;
        this.x = x ;
        this.y = y ;
    }
    public Object clone()
    {   System.out.println("Clone de Point_cloneable") ;
        Object o = new Point_cloneable(this.x, this.y) ;
        return o ;
    }
    public int getX() {return this.x ; }
    public int getY() {return this.y ; }
    public void affiche()
    { System.out.println("Je suis un " + this + " de coordonnées x y " + x + " " + y) ;
    }
    private int x ;
    private int y ;
}

class PointCol_cloneable implements Cloneable {
    PointCol_cloneable(int x, int y, String couleur)
    {   System.out.println("Constructeur de PointCol_cloneable") ;
        this.p = new Point_cloneable(x, y) ;
        this.couleur = couleur ;
    }
    
    public Object clone()
    {   System.out.println("Clone de PointCol_cloneable") ;
        Object o = new PointCol_cloneable(this.p.getX(), this.p.getY(), this.couleur) ;
        return o ;
    }
    public void affiche()
    { System.out.println("Je suis un " + this + " de coordonnées d'un point situé " + p + " x y " + this.p.getX() + " " + this.p.getY() + " et de couleur " + couleur) ;
    }
    private Point_cloneable p ;
    private String couleur ;
}