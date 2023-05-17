import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

class FenDialog extends JFrame implements ActionListener {
    public FenDialog ()
    {   setTitle ("Raccourcis") ;
        setSize (400, 200) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        barre = new JMenuBar() ;
        setJMenuBar(barre);

        couleur = new JMenu("Couleur") ;
        couleur.setMnemonic('C');
        barre.add(couleur) ;

        bleu = new JMenuItem("Bleu") ;
        bleu.setMnemonic('B');
        bleu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_DOWN_MASK));
        couleur.add(bleu) ;
        bleu.addActionListener(this);

        couleur.addSeparator() ;

        // utiliser l'option mnémomique en tapant le char qd le menu est ouvert pour sélectionner l'option
        // pour le raccourci, taper (voir la combinaison de touche) ici : control + R (ou r)
        rouge = new JMenuItem("Rouge") ;
        rouge.setMnemonic('R');
        rouge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_DOWN_MASK));
        couleur.add(rouge) ;
        rouge.addActionListener(this);

        dimension = new JMenu("Dimension") ;
        dimension.setMnemonic('D');
        barre.add(dimension) ;

        hauteur = new JMenuItem("Hauteur") ;
        hauteur.setMnemonic('H');
        hauteur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_DOWN_MASK));
        dimension.add(hauteur) ;
        hauteur.addActionListener(this);

        dimension.addSeparator() ;

        largeur = new JMenuItem("Largeur") ;
        largeur.setMnemonic('L');
        largeur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.CTRL_DOWN_MASK));
        dimension.add(largeur) ;
        largeur.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e)
    {   System.out.println("Clic sur " + e.getActionCommand()) ;
        if      (e.getSource() == bleu) System.out.println("Action bleu") ;
        else if (e.getSource() == rouge) System.out.println("Action rouge") ;
        else if (e.getSource() == hauteur) System.out.println("Action hauteur") ;
        else if (e.getSource() == largeur) System.out.println("Action largeur") ;
    }
    private JMenuBar barre ;
    private JMenu couleur, dimension ;
    private JMenuItem bleu, rouge, hauteur, largeur ;
}

public class C_raccourcis_dit_accelerateurs {
    public static void main(String[] args) {
        FenDialog fen = new FenDialog() ;
        fen.setVisible(true) ;
    }
}
