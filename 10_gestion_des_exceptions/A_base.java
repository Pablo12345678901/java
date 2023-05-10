public class A_base {
    public static void main(String[] args) {
        try
        {   Point a = new Point(1, 2) ;
            a.affiche() ;
            //Point b = new Point (-1, 4) ;
            //b.affiche() ;
            a.deplace(2, 4) ;
            a.affiche() ;
            a.deplace(-10, -10) ;
            a.affiche() ;
        }
        catch (CoordNeg e)
        {   System.out.println(e.getMessage()) ;
            System.exit(-1) ; // arrêt du programme
        }
        catch (DeplHorsTerrain e)
        {   System.out.println("Exception : déplacement refusé car sortie du terrain\nCoordonnées initiales x y : " + e.x + " " + e.y + "\nDéplacement souhaité dx dy : " + e.dx + " " + e.dy + "\nNouvelle position théorique Nx Ny : " + (e.x+e.dx) + " " + (e.y + e.dy)) ;
            System.exit(-1) ; // arrêt du programme
        }
    }
}

class Point
{
    public Point(int x, int y) throws CoordNeg
    {   if (x<0 || y<0) throw new CoordNeg("Exception : constructeur car coordonnées négatives x y : " + x + " " + y ) ;
        else 
        {   System.out.println("Constructeur") ;
            this.x = x ; this.y = y ; // test pour voir si possible car je pense que bug car constructeur doit définir x et y
        }
    }
    public void deplace(int dx, int dy) throws DeplHorsTerrain
    {   if (x+dx<0 || y+dy<0) throw new DeplHorsTerrain(x, y, dx, dy) ;
        else
        {   System.out.println("Déplacement") ;
            x += dx ; y += dy ;
        }
    }
    public void affiche()
    {   System.out.println("Le " + this + " se situe en x y " + x + " " + y) ;
    }
    private int x, y ;
}

class CoordNeg extends Exception
{   CoordNeg(String mes)
    { super(mes) ;
    }
}
class DeplHorsTerrain extends Exception
{   DeplHorsTerrain(int x, int y, int dx, int dy)
    { this.x = x ; this.y = y ; this.dx = dx ; this.dy = dy ;
    }
    public int x, y, dx, dy  ;
}