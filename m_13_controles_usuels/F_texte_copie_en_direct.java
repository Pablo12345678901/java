import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.* ;

class Fenetre extends JFrame implements DocumentListener {
    public Fenetre() {
        setBounds(0, 300, 400, 100);
        setTitle("Champs de texte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
    
        titre = new JLabel("Tapez un texte") ;
        contenu.add(titre) ;

        texte_saisi = new JTextField(20) ;
        texte_saisi.getDocument().addDocumentListener(this) ;
        contenu.add(texte_saisi) ;

        texte_copie = new JTextField(20) ;
        texte_copie.setEditable(false);
        contenu.add(texte_copie) ;
    }
    public void insertUpdate(DocumentEvent e) // en cas de rédaction
    {   texte_str = texte_saisi.getText() ;
        texte_copie.setText(texte_str);
    }
    public void removeUpdate(DocumentEvent e) // en cas de suppression de texte
    {   texte_str = texte_saisi.getText() ;
        texte_copie.setText(texte_str);
    }
    public void changedUpdate(DocumentEvent e) {} // non utilisée

    private JLabel titre ;
    private String texte_str ;
    private JTextField texte_saisi, texte_copie ;
}
    
public class F_texte_copie_en_direct {
    public static void main(String[] args) {
        Fenetre ma_fenetre = new Fenetre() ;
        ma_fenetre.setVisible(true);
    }    
}
