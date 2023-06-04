public class A_class_point{
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