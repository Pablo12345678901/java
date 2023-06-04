import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

class FenDialog extends JFrame implements ActionListener {
    public FenDialog ()
    { setTitle ("Essai boite de dialogue") ;
        setSize (400, 200) ;
        lanceDial = new JButton ("Lancement dialogue") ;
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout()) ;
        contenu.add(lanceDial) ;
        lanceDial.addActionListener(this) ;
    }
    public void actionPerformed (ActionEvent e)
    { MonDialogue bd = new MonDialogue(this) ;
        System.out.println ("avant affichage boite dialogue") ;
        bd.setVisible(true) ;
        System.out.println ("apres fermeture boite dialogue") ;
    }
    private JButton lanceDial ;
}

class MonDialogue extends JDialog {
    public MonDialogue (JFrame proprio) {
        super (proprio, "Mon dialogue", true) ;
        setSize(250, 100) ;
    }
}

public class G_boite_de_dialogue_sur_mesure {
    public static void main(String[] args) {
        FenDialog fen = new FenDialog() ;
        fen.setVisible(true) ;
    }

}
