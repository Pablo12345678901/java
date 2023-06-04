//package ZZZ_Ressources_livres.chap17;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

class MaFenetre extends JFrame {
    public MaFenetre ()
    {   setTitle ("Exemple BoxLayout horizontal") ;
        setSize (200, 150 ) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;

        Container contenu = getContentPane() ;
        // 1er BoxLayout
        bVert = Box.createVerticalBox() ;
        b1 = new JButton ("Bouton1") ;
        bVert.add (b1) ;
        txt = new JTextField (20) ;
        txt.setMaximumSize(new Dimension(125, 100)) ; 
        bVert.add (txt) ;
        coche1 = new JCheckBox ("case a cocher") ;
        coche1.setPreferredSize(new Dimension(125, 100)) ;
        bVert.add (coche1) ;
        etiq = new JLabel ("Bonjour") ;
        bVert.add(etiq) ;
        // 2ème BoxLayout
        bHor = Box.createHorizontalBox() ;
        bHor.add(bVert) ;
        panneau_couleur = new JPanel() ;
        panneau_couleur.setBackground(new Color(0.29f, 0.38f, 0.45f)) ;
        bHor.add(panneau_couleur) ;

        contenu.add(bHor) ;

    }
    private Box bVert, bHor ;
    private JButton b1 ;
    private JCheckBox coche1 ;
    private JTextField txt ;
    private JLabel etiq ;
    private JPanel panneau_couleur ;
}

public class C_BoxLayout {
    public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}
