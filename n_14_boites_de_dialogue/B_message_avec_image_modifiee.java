import java.awt.Color;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

public class B_message_avec_image_modifiee {
    public static void main(String[] args) {
        Mafenetre fen = new Mafenetre() ;
        fen.setVisible(true); 

        String[] options = { "brownie", "pie", "cake" };
        String choix = "" ;

        int dessert = JOptionPane.showOptionDialog(fen, "Which dessert would you like?", "Select a dessert", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("image_test.png"), options, options[0]);
        
        if (dessert == 0) choix = options[0] ;
        else if (dessert == 1) choix = options[1] ;
        else if (dessert == 2) choix = options[2] ;
        else choix = "ERREUR : choix inconnu" ;

        JOptionPane.showMessageDialog(fen, "You have choosen a " + choix + ".", "Votre choix", JOptionPane.DEFAULT_OPTION, new ImageIcon("image_test.png"));
    }
}

class Mafenetre extends JFrame {
    public Mafenetre()
    {   super() ;
        setBounds(300, 300, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        
        JPanel panneau = new JPanel() ;
        Color color = new Color(0.4f, 0.65f, 0.88f) ;
        panneau.setBackground(color);
        contenu.add(panneau) ;
        
    }
}
