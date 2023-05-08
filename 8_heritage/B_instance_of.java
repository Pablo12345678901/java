public class B_instance_of {
    public static void main(String[] args) {
        PointCol_2 pc1 = new PointCol_2(10, 20, 100) ;
        Point_1 p1 = new Point_1(30, 40) ;
        Point_1 p2 = new Point_1(50, 60) ;
        Point_1 [] tableau = new Point_1 [3] ;
        tableau[0] = pc1 ;
        tableau[1] = p1 ;
        tableau[2] = p2 ;
        for (int i=0; i<(3-1); i++)
        {   System.out.println("Boucle n°" + (i+1)) ;
            tableau[i].affiche() ;
            tableau[i+1].affiche() ;
            tableau[i+1] = tableau[i] ;
            tableau[i+1].affiche() ;
            if (tableau[i+1] instanceof PointCol_2)
            {   System.out.println("Conversion possible -> PointCol_2 avec (cast) est possible car l'objet en est une référence.") ;
                tableau[i] = (PointCol_2) tableau[i+1] ;
                tableau[i].affiche();
                tableau[i+1] = p2 ;
            }
            else System.out.println("Conversion impossible -> PointCol_2 car l'objet n'est pas une référence à un PointCol_2.") ;
            System.out.println() ;
        }
    }    
}

class Point_1 {
    public Point_1(int x, int y)
    {   this.x = x ; this.y = y ;
        System.out.println("Constructeur de Point_1") ;   
    }
    public void affiche()
    {   identifie() ;
        System.out.println(" et mes coordonnées sont x y " + x + " " + y + ".");
    }
    public void identifie()
    { System.out.print("Je suis un Point_1") ;
    }
    private int x ;
    private int y ;
}

class PointCol_2 extends Point_1 {
    public PointCol_2(int x, int y, int col)
    {   super(x, y) ;
        this.col = col ;
        System.out.println("Constructeur de PointCol_2") ;   
    }
    public void identifie()
    {   System.out.print("Je suis un PointCol_2") ;
        infosup() ;
    }
    public void infosup()
    {   System.out.print(", ma couleur est " + col) ;
    }
    private int col ;
}