import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

public class C_boite_de_confirmation {
    public static void main(String[] args) {
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
