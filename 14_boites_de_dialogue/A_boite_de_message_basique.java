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

public class A_boite_de_message_basique {
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
    }
}
