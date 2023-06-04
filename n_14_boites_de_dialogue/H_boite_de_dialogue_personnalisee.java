import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.* ;
import java.awt.event.* ;

class FenDialog extends JFrame implements ActionListener {
    public FenDialog ()
    { setTitle ("Boîte de dialogue personnalisée") ;
        setSize (400, 200) ;

        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout()) ;

        lanceDial = new JButton ("Saisir un texte") ;
        contenu.add(lanceDial) ;
        lanceDial.addActionListener(this) ;
    }
    public void actionPerformed (ActionEvent e)
    {   System.out.println("Ancien texte saisi : " + valueTextField) ;
        valueTextField = null ;
        MonDialogue bd = new MonDialogue(this) ;
        //DEBUG System.out.println ("Avant affichage boite dialogue") ;
        bd.setVisible(true) ;
        //DEBUG System.out.println ("Après fermeture boite dialogue") ;
    }
    public void getTextField(MonDialogue bd)
    {   this.valueTextField = bd.getValueTextField() ;
    }
    private JButton lanceDial ;
    private String valueTextField = null ;
}

class MonDialogue extends JDialog implements ActionListener {
    public MonDialogue (JFrame proprio) {
        super (proprio, "Texte", true) ;
        this.proprio = (FenDialog) proprio ; // attention conversion forcée
        setSize(250, 100) ;
        
        Container contenu_boite = getContentPane() ;
        contenu_boite.setLayout(new FlowLayout()) ;
        
        texte_saisi = new JTextField(null, null, 20);
        contenu_boite.add(texte_saisi) ;

        validation = new JButton("OK", null) ;
        contenu_boite.add(validation) ;
        validation.addActionListener(this);

        cancel = new JButton("Quitter", null) ;
        contenu_boite.add(cancel) ;
        cancel.addActionListener(this);
    }
    public void actionPerformed (ActionEvent e)
    {   if (e.getSource() == validation)
        {   valueTextField = texte_saisi.getText() ;
            if (valueTextField.length()>0) System.out.println("Texte saisi : " + valueTextField) ;
            else System.out.println("Texte saisi vide") ;
        }
        else if (e.getSource() == cancel)
        {   valueTextField = null ;
            System.out.println("L'utilisateur a fermé la boîte de dialogue avec le bouton \"quitter\" sans saisir de texte.") ;
        }
        proprio.getTextField(this) ;
        setVisible(false) ;
        dispose() ; // libératio de la mémoire
    }
    public String getValueTextField() { return valueTextField ;}
    private FenDialog proprio ;
    private String valueTextField ;
    private JButton validation ;
    private JButton cancel ;
    private JTextField texte_saisi ;
}

public class H_boite_de_dialogue_personnalisee {
    public static void main(String[] args) {
        FenDialog fen = new FenDialog() ;
        fen.setVisible(true) ;
    }
}
