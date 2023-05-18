//package ZZZ_Ressources_livres.chap17;
import javax.swing.* ;
import java.awt.* ;

class MaFenetre extends JFrame {
    public static int NBOUTONS = 5 ;
    public MaFenetre ()
    {   setTitle ("Exemple BorderLayout") ;
        setSize (300, 180) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contenu = getContentPane() ;
        // Inclusion de 2 BorderLayout afin de permettre à un élément de prendre toute la hauteur en West (à gauche)
        //impossible si que 1 seul Borderlayout car par défaut le North et South prennent toute la largeur du BorderLayout
        JPanel panneau_big = new JPanel(new BorderLayout()) ;
        JPanel panneau_little = new JPanel(new BorderLayout()) ;
        
        boutons = new JButton[NBOUTONS] ;
        for (int i=0 ; i<NBOUTONS ; i++)
        { boutons[i] = new JButton ("Bouton " + i) ;
        }
        // BorderLayout 1
        panneau_little.add(boutons[0]) ;      // au centre par defaut
        panneau_little.add(boutons[4], BorderLayout.EAST) ;
        panneau_little.add(boutons[1], BorderLayout.NORTH) ;
        panneau_little.add(boutons[2], BorderLayout.SOUTH) ;
        // BorderLayout 2 : composé du BorderLayout 1 et d'un bouton West
        panneau_big.add(boutons[3], BorderLayout.WEST) ;
        panneau_big.add(panneau_little,BorderLayout.EAST) ;

        contenu.add(panneau_big) ;
    }
    private JButton boutons[] ;
}
public class A_borderlayout {
    public static void main (String args[])
    { MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}
