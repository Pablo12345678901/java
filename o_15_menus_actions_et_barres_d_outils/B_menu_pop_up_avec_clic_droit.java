import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

class FenDialog extends JFrame implements ActionListener {
    public FenDialog ()
    {   setTitle ("Pop-up clic droit") ;
        setSize (400, 200) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        couleur = new JPopupMenu() ;

        bleu = new JMenuItem("Bleu") ;
        couleur.add(bleu) ;
        bleu.addActionListener(this);

        couleur.addSeparator() ;

        rouge = new JMenuItem("Rouge") ;
        couleur.add(rouge) ;
        rouge.addActionListener(this);

        addMouseListener(new MouseAdapter()
        {   public void mousePressed(MouseEvent e)
            {  if (e.isPopupTrigger()) couleur.show((Component)e.getSource(), e.getX(), e.getY()) ;
                //DEBUG else System.out.println("Autre "+ (++nb_clic)) ;
            }
        });
    }
    public void actionPerformed (ActionEvent e)
    {   System.out.println("Clic sur " + e.getActionCommand()) ;
        if      (e.getSource() == bleu) System.out.println("Action bleu") ;
        else if (e.getSource() == rouge) System.out.println("Action rouge") ;
    }
    private JPopupMenu couleur ;
    private JMenuItem bleu, rouge ;
    private static int nb_clic = 0 ;
}

public class B_menu_pop_up_avec_clic_droit {
    public static void main(String[] args) {
        FenDialog fen = new FenDialog() ;
        fen.setVisible(true) ;
    }
}
