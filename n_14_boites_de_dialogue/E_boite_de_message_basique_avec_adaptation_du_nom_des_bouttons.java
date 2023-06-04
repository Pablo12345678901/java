import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

class MaFenetre extends JFrame
{   public MaFenetre ()
    {   setTitle ("Boîte de dialogue basique") ;
        setSize (500, 300) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class E_boite_de_message_basique_avec_adaptation_du_nom_des_bouttons {
    public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
        System.out.println("Avant boîte dialogue") ;
        JOptionPane.showMessageDialog(fen, "Hello");
        JOptionPane.showMessageDialog(null, "Hello hors fenêtre"); // avec paramètres "null"
        JOptionPane.showMessageDialog(fen, "Message", "Titre", JOptionPane.WARNING_MESSAGE); // dernier paramètre au choix parmi :
        /*
        ERROR_MESSAGE
        INFORMATION_MESSAGE
        WARNING_MESSAGE
        QUESTION_MESSAGE
        PLAIN_MESSAGE
        */
        System.out.println("Après boîte dialogue") ;
        // Configuration de l'intitulé des boutons
        UIManager.put("OptionPane.okButtonText", "D'accord");
        UIManager.put("OptionPane.yesButtonText", "Entendu");
        UIManager.put("OptionPane.noButtonText", "Je refuse");
        UIManager.put("OptionPane.cancelButtonText", "Quitter");
        
        String choix ;
        while (true)
        {   // Version simple
            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous continuer ?") ;
            // Version avancée :
            //int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous continuer ?", "Question pour un champion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("image_test.png")) ;
            if      (rep == -1) {   choix = "CLOSED_OPTION" ; break ; }
            else if (rep == 0)      choix = "YES_OPTION" ;
            else if (rep == 1)      choix = "NO_OPTION" ;
            else if (rep == 2) {    choix = "CANCEL_OPTION" ; break; }
            else                    choix = "ERREUR : choix inconnu" ;
            System.out.println("Vous avez choisi : " + choix) ;
        } 
    }
}
