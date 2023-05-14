import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame implements ActionListener, FocusListener {
    public Fenetre() {
        setBounds(0, 300, 400, 100);
        setTitle("Champs de texte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
    
        titre = new JLabel("Tapez un texte") ;
        contenu.add(titre) ;

        texte_saisi = new JTextField(20) ;
        texte_saisi.addActionListener(this);
        texte_saisi.addFocusListener(this);
        contenu.add(texte_saisi) ;

        validation = new JButton("Copier ") ;
        validation.addActionListener(this);  
        contenu.add(validation) ;

        texte_copie = new JTextField(20) ;
        texte_copie.setEditable(false);
        contenu.add(texte_copie) ;
    }
    public void actionPerformed(ActionEvent e)
    {   System.out.println("Action") ;
        texte_str = texte_saisi.getText() ;
        texte_copie.setText(texte_str);
        System.out.println("Le texte saisi est :\n" + texte_str) ;
    }
    public void focusGained(FocusEvent e)
    {   System.out.println("Focus gained") ;
        texte_str = texte_saisi.getText() ;
        texte_copie.setText(texte_str);
        System.out.println("Le texte saisi est :\n" + texte_str) ;
    }
    public void focusLost(FocusEvent e)
    {   System.out.println("Focus lost") ;
        texte_str = texte_saisi.getText() ;
        texte_copie.setText(texte_str);
        System.out.println("Le texte saisi est :\n" + texte_str) ;
    }

    private JButton validation ;
    private JLabel titre ;
    private String texte_str ;
    private JTextField texte_saisi, texte_copie ;
}
    
public class E_champs_de_texte_et_focus {
    public static void main(String[] args) {
        Fenetre ma_fenetre = new Fenetre() ;
        ma_fenetre.setVisible(true);
    }    
}