//package ZZZ_Ressources_livres.chap16;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

class MaFenetre extends JFrame implements KeyListener
{   public MaFenetre ()
    {   setTitle ("Exemple lecture clavier") ;
        setSize (300, 180) ;
        addKeyListener (this) ;
    }
    public void keyPressed (KeyEvent e)
    {   code = e.getKeyCode() ;
        //DEBUG System.out.println ("Touche "+code+ " pressee : " + e.getKeyText (code)) ;
    }
    public void keyReleased (KeyEvent e)
    {   code = e.getKeyCode() ;
        //DEBUG System.out.println ("Touche "+code+ " relachee : " + e.getKeyText (code)) ;
    }
    public void keyTyped (KeyEvent e)
    {   char c = e.getKeyChar() ;
        //DEBUG System.out.println ("Caractere frappe : " + c + " de code " + (int)c) ;
        //DEBUG System.out.println("Code : " + code) ;
        if (code == 8) // Le code 8 correspond au caractère d'effacement
        {   System.out.print(c) ; // qui revient d'un caractère en arrière - comme si pointeur -=1
            System.out.print(" ") ; // puis j'écris un espace pour remplacer le caractère à effacer - je donne l'illusion qu'il a été effacé mais il a été remplacé)
            System.out.print(c) ; // puis je revient d'un caractère en arrière
        }
        else if (c == '\n') System.out.print('\n') ; // pour les retours à la ligne
        else System.out.print(c) ;
    }
    private int code = -1 ;
    private char c = ' ' ;
}

public class B_taper_du_texte_et_detecter_touches_clavier {
    public static void main (String args[])
    { MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}
