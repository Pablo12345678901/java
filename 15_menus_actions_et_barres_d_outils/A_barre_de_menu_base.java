import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

class FenDialog extends JFrame implements ActionListener {
    public FenDialog ()
    { setTitle ("Boîte de dialogue personnalisée") ;
        setSize (400, 200) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        barre = new JMenuBar() ;
        setJMenuBar(barre);

        couleur = new JMenu("Couleur") ;
        barre.add(couleur) ;
        dimension = new JMenu("Dimension") ;
        barre.add(dimension) ;

        bleu = new JMenuItem("Bleu") ;
        couleur.add(bleu) ;
        bleu.addActionListener(this);

        couleur.addSeparator() ;

        rouge = new JMenuItem("Rouge") ;
        couleur.add(rouge) ;
        rouge.addActionListener(this);

        largeur = new JMenuItem("Largeur") ;
        dimension.add(largeur) ;
        largeur.addActionListener(this);

        dimension.addSeparator() ;

        hauteur = new JMenuItem("Hauteur") ;
        dimension.add(hauteur) ;
        hauteur.addActionListener(this);
    }
    public void actionPerformed (ActionEvent e)
    {   //DEBUG System.out.println("Clic sur " + e.getActionCommand()) ;
        if      (e.getSource() == bleu) System.out.println("Action bleu") ;
        else if (e.getSource() == rouge) System.out.println("Action rouge") ;
        else if (e.getSource() == largeur) System.out.println("Action largeur") ;
        else if (e.getSource() == hauteur) System.out.println("Action hauteur") ;
    }
    private JMenuBar barre ;
    private JMenu couleur, dimension ;
    private JMenuItem bleu, rouge, largeur, hauteur ;
}

public class A_barre_de_menu_base {
    public static void main(String[] args) {
        FenDialog fen = new FenDialog() ;
        fen.setVisible(true) ;
    }
}
