import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

class MaFenetre extends JFrame implements ActionListener {
    public static int NBOUTONS = 100 ;
    public MaFenetre ()
    {   setTitle("CardLayout") ;
        setSize(400, 180) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        contenu.setLayout(new BorderLayout()) ;
        
        // panneau pour la pile
        panCard = new JPanel() ; 
        contenu.add(panCard, "Center") ;
        
        // panneau pour les boutons de parcours de la pile
        panCom = new JPanel() ;  
        contenu.add(panCom, "South") ;
        
        // creation de la pile de boutons et ajout au premier panneau
        pile = new CardLayout(30, 10) ;
        panCard.setLayout (pile) ;
        boutons = new JButton[NBOUTONS] ;
        for (int i=0 ; i<NBOUTONS ; i++)
        {   boutons[i] = new JButton("Bouton " + i) ;
            //DEBUG System.out.println("Nom : " + boutons[i].getActionCommand()) ; // affiche le texte des boutons (initialisé à "bouton "+ i)
            panCard.add(boutons[i], "Bouton " + i) ; // identification obligatoire ici - chaîne vide possible ""
        }
        // creation des boutons de parcours de la pile dans le 2ème panneau
        prec = new JButton("Précédent") ;
        panCom.add (prec) ;
        prec.addActionListener(this) ;
        suiv = new JButton("Suivant") ;
        panCom.add (suiv) ;
        suiv.addActionListener(this) ;
        prem = new JButton("Premier") ;
        panCom.add (prem) ;
        prem.addActionListener(this) ;
        der = new JButton("Dernier") ;
        panCom.add (der) ;
        der.addActionListener(this) ;
    }
    public void actionPerformed (ActionEvent e) // utilisation des méthodes du CardLayout pour afficher le bouton souhaité
    {   for (Component comp : panCard.getComponents()) // obtention de tous les composants du CardLayout
        { if (comp.isVisible() == true) // contrôle si c'est celui qui est visible
            {   current_button = (JButton) comp ; // Obtention de la référence convertie en JButton
                current_button_name = current_button.getActionCommand() ; // Obtention du nom du bouton visible
                break ;
            }
        }
        JButton source = (JButton)e.getSource() ;
        if (source == prec)
        {   if (current_button_name != boutons[0].getActionCommand()) pile.previous(panCard) ;
            else System.out.println("Précédent impossible car premier bouton.") ;
            return ;
        }
        if (source == suiv)
        {   //DEBUG System.out.println("current_card : " + current_card + " boutons[7] : " + boutons[7].getActionCommand()) ;
            if (current_button_name != boutons[boutons.length-1].getActionCommand()) pile.next (panCard) ;
            else System.out.println("Suivant impossible car dernier bouton.") ;
            return ;
        }
        if (source == prem) pile.first (panCard) ;
        if (source == der)  pile.last (panCard) ;
    }
    private JButton boutons[], current_button = null ;
    private JPanel panCard, panCom ;
    private String current_button_name ;
    private CardLayout pile ;
    private JButton prec, suiv, prem, der ;
}

public class B_cardlayout {
    public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}