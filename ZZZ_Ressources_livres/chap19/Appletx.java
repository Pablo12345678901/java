package zzz_ressources_livres.chap19;
import java.awt.* ;
import javax.swing.* ;
public class Appletx extends JApplet
{   public Appletx ()
    { System.out.println ("const") ;     Clavier.lireInt();
    }
    public void init()
    { System.out.println ("init") ; Clavier.lireInt() ;
    }
}


