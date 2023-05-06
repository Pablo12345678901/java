public class A_polymorphisme_et_redefinition {
    public static void main(String[] args) {
        //Point p1 = new Point(1,2) ;
        Point [] tableau_points_variants ;
        tableau_points_variants = new Point[5] ;
        tableau_points_variants[0] = new Point(1, 2) ;
        tableau_points_variants[1] = new PointCol(3, 4, 100) ;
        tableau_points_variants[2] = new PointColNom(5, 6, 200, "Bogoss") ;
        tableau_points_variants[3] = new PointCol(7, 8, 300) ;
        Point p5 = new Point(9, 10) ; 
        tableau_points_variants[4] = p5 ;
        for (Point p : tableau_points_variants) p.affiche() ;
    }    
}

class Point {
    public Point(int x, int y)
    {   this.x = x ; this.y = y ;
        System.out.println("Constructeur de Point") ;   
    }
    public void affiche()
    {   identifie() ;
        System.out.println(" et mes coordonnées sont x y " + x + " " + y + ".");
    }
    public void identifie()
    { System.out.print("Je suis un Point") ;
    }
    private int x ;
    private int y ;
}
class PointCol extends Point {
    public PointCol(int x, int y, int col)
    {   super(x, y) ;
        this.col = col ;
        System.out.println("Constructeur de PointCol") ;   
    }
    public void identifie()
    {   System.out.print("Je suis un PointCol") ;
        infosup() ;
    }
    public void infosup()
    {   System.out.print(", ma couleur est " + col) ;
    }
    private int col ;
}
class PointColNom extends PointCol {
    public PointColNom(int x, int y, int col, String nom)
    {   super(x, y, col) ;
        this.nom = nom ;
        System.out.println("Constructeur de PointColNom") ;   
    }
    public void identifie()
    {   System.out.print("Je suis un PointColNom") ;
        super.infosup() ;
        infosup() ;
    }
    public void infosup()
    {   System.out.print(", mon nom est " + nom) ;
    }
    public String nom ;
}
