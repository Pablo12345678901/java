//package Z_debug;
import javax.swing.* ;
//import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

class FenDialog extends JFrame implements ActionListener {
    public FenDialog ()
    {   setTitle ("Raccourcis") ;
        setSize (400, 200) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        barre = new JMenuBar() ;
        setJMenuBar(barre);
        
        // initialisation des actions
        actionRouge = new ActionCouleur("ROUGE", Color.red) ;
        actionBleu = new ActionCouleur("BLEU", Color.blue) ;

        // Barre de menu
        couleur = new JMenu("Couleur") ;
        barre.add(couleur) ;
        couleur.add(actionRouge) ;
        couleur.addSeparator() ;
        couleur.add(actionBleu) ;

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

        // Menu pop-up de 2 options
        pop_up_couleur = new JPopupMenu() ;
        pop_up_couleur.add(actionRouge) ;
        pop_up_couleur.add(actionBleu) ;
        addMouseListener(new MouseAdapter()
        {   public void mousePressed(MouseEvent e)
            {   //if (e.isPopupTrigger()) pop_up_couleur.show((Component)e.getSource(), e.getX(), e.getY()) ;
                if (e.isPopupTrigger()) pop_up_couleur.show(e.getComponent(), e.getX(), e.getY()) ;
                //DEBUG else System.out.println("Autre "+ (++nb_clic)) ;
            }
        });

        // 2 Boutons - 2 actions identiques aux autres
        Container container = getContentPane() ;
        //container.setLayout(new FlowLayout());
        
        bouton_rouge = new JButton((String)actionRouge.getValue(Action.NAME)) ; // Avec conversion de l'objet obtenu en String
        container.add(bouton_rouge, "West") ;
        bouton_rouge.addActionListener(actionRouge) ;

        bouton_bleu = new JButton((String)actionBleu.getValue(Action.NAME)) ; // Avec conversion de l'objet obtenu en String
        container.add(bouton_bleu, "East") ;
        bouton_bleu.addActionListener(actionBleu) ;
    }

    
    public void actionPerformed (ActionEvent e)
    {   System.out.println("Clic sur " + e.getActionCommand()) ;
        if (e.getSource() == hauteur) System.out.println("Action hauteur") ;
        else if (e.getSource() == largeur) System.out.println("Action largeur") ;
    }
    private JPopupMenu pop_up_couleur ;
    private JMenuBar barre ;
    private JMenu couleur, dimension ;
    private JMenuItem hauteur, largeur ;
    private ActionCouleur actionRouge, actionBleu ;
    private JButton bouton_rouge, bouton_bleu ;
}

class ActionCouleur extends AbstractAction {
    public ActionCouleur(String nom, Color couleur)
    {   super(nom) ;
        this.couleur = couleur ;
    }
    public void actionPerformed (ActionEvent e)
    {   System.out.println("Clic sur " + e.getActionCommand()) ;
        if      (couleur == Color.blue) System.out.println("Action bleu") ;
        else if (couleur == Color.red) System.out.println("Action rouge") ;
    }
    private Color couleur ;
}

public class E_abstract_action_meme_action_plusieurs_source {
    public static void main(String[] args) {
        FenDialog fen = new FenDialog() ;
        fen.setVisible(true) ;
    }
}
