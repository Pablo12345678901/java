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

public class F_choix_via_boite_combo_ou_liste_options {
    public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
        // Configuration de l'intitulé des boutons
        UIManager.put("OptionPane.okButtonText", "Ok");
        UIManager.put("OptionPane.yesButtonText", "Oui");
        UIManager.put("OptionPane.noButtonText", "Non");
        UIManager.put("OptionPane.cancelButtonText", "Quitter");
        // Liste des choix
        String [] liste_couleurs = {"bleu", "jaune", "vert", "rouge", "orange", "doré", "noir"} ;
        String choix = null ;
        while (choix == null)
        {   choix = (String) JOptionPane.showInputDialog(fen, "Choisissez votre couleur préférée :", "Couleur préférée", JOptionPane.QUESTION_MESSAGE, null, liste_couleurs, liste_couleurs[0]) ;
            if (choix == null) JOptionPane.showMessageDialog(fen, "Vous n'avez fait aucun choix.\nVeuillez en faire un.", "Message d'erreur", JOptionPane.WARNING_MESSAGE) ;
        }
        JOptionPane.showMessageDialog(fen, "Merci pour votre choix : " + choix, "Choix final", JOptionPane.INFORMATION_MESSAGE) ;
        
        int index_choix = -1 ;
        while (index_choix<0)
        {   index_choix = JOptionPane.showOptionDialog(fen, "Choisissez votre couleur préférée :", "Couleur préférée", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, liste_couleurs, liste_couleurs[0]) ;
            if (index_choix<0) JOptionPane.showMessageDialog(fen, "Vous n'avez fait aucun choix.\nVeuillez en faire un.", "Message d'erreur", JOptionPane.WARNING_MESSAGE) ;
        }
        JOptionPane.showMessageDialog(fen, "Merci pour votre choix : " + liste_couleurs[index_choix], "Choix final", JOptionPane.INFORMATION_MESSAGE) ;
        /* 
        optionType one of :
        DEFAULT_OPTION
        YES_NO_OPTION
        YES_NO_CANCEL_OPTION
        OK_CANCEL_OPTION
        */
        /*
        messageType one of :
        ERROR_MESSAGE
        INFORMATION_MESSAGE
        WARNING_MESSAGE
        QUESTION_MESSAGE
        PLAIN_MESSAGE
        */
    }
}
