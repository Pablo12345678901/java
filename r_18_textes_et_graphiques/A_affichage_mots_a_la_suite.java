//package ZZZ_Ressources_livres.chap18;
import javax.swing.* ;
import java.awt.* ;

public class A_affichage_mots_a_la_suite
{   public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}

class MaFenetre extends JFrame
{   MaFenetre ()
    {   setTitle ("Essai texte") ;
        setSize (300, 150) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;

        pan = new Paneau() ;
        getContentPane().add(pan) ;
    }
    private JPanel pan ;
}
class Paneau extends JPanel
{   public void paintComponent(Graphics g)
    {   super.paintComponent(g) ;
        String ch_courant = null;
        String ch_nouveau = null;
        int x = 20, y = 30 ;
        debut :
        while (true)
        {   System.out.println("Boucle " + (++i)) ;
            if (ch_courant == null)
            {   System.out.println("Dans if") ;
                System.out.print("Mot à écrire : ") ;
                ch_courant = Clavier.lireString() ;
                System.out.println("ch_courant vaut : " + ch_courant) ;
                g.drawString(ch_courant, x, y) ;
            }
            else
            {   System.out.println("Dans else") ;
                FontMetrics fm = g.getFontMetrics() ;
                x += fm.stringWidth (ch_courant) ;
                System.out.print("Mot à écrire : (taper enter pour arrêter)") ;
                ch_nouveau = Clavier.lireString() ;
                System.out.println("ch_nouveau longueur : " + ch_nouveau.length()) ;
                if (ch_nouveau.length()==0) break ;
                else
                {   System.out.println("ch_nouveau vaut : " + ch_nouveau) ;
                    g.drawString (ch_nouveau, x, y) ;
                    ch_courant = ch_nouveau ;
                    System.out.println("ch_courant vaut : " + ch_courant) ;
                    System.out.println("Fin else") ;
                }
            }
        }
    }
    private static int i = 0 ;
}


