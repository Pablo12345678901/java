package zd_30_design_patterns;

public class ATestFabrique
{ public static void main (String args[])
  { FabriqueLogoHasard fab = new FabriqueLogoHasard () ;
    for (int i = 0 ; i<10 ; i++) 
    { Logo l = fab.getLogo() ;
      l.affiche();
    }  
    // Pour le fun afin de tester si random est réellement random - devrait tendre vers 1/2.
    System.out.println("Il y a eu " + LogoCercle.getNbLogoCercle() + " Logo circulaire et " + LogoRectangle.getNbLogoRectangle()+ " Logo rectangle soit une proportion de " + (int)((double)LogoCercle.getNbLogoCercle() * 100 / (double)(LogoRectangle.getNbLogoRectangle()+LogoCercle.getNbLogoCercle())) + "%.") ;
  }
}

abstract class Logo
{ abstract void affiche () ;
}

class LogoCercle extends Logo
{ public void affiche () { System.out.println ("Logo circulaire") ; counter_LogoCercle++ ; }
    public static int getNbLogoCercle() { return counter_LogoCercle ;}
    private static int counter_LogoCercle = 0 ;
}

class LogoRectangle extends Logo
{ public void affiche () { System.out.println ("Logo rectangle") ; counter_LogoRectangle++ ; }
    public static int getNbLogoRectangle() { return counter_LogoRectangle ;}
    private static int counter_LogoRectangle = 0 ;
}

class FabriqueLogoHasard
{ public Logo getLogo()
  { double x = Math.random () ;
    if (x < 0.5) return new LogoCercle () ; 
            else return new LogoRectangle () ;
  }
}


