import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame implements ActionListener {
    public Fenetre() {
        setBounds(0, 300, 400, 100);
        setTitle("Compteur de clics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
    
        compteur = new JButton("Cliquez !") ;
        compteur.addActionListener(this);  
        contenu.add(compteur) ;

        texte_base = new JLabel("Nb de clic : ") ;
        contenu.add(texte_base) ;
        texte_clics = new JLabel(""+nb_clic) ;
        contenu.add(texte_clics) ;
    }
    public void actionPerformed(ActionEvent e)
    {   System.out.println("\nNouveau clic\nClics totaux : " + (++nb_clic)) ;
        texte_clics.setText("" + nb_clic) ;
    }

    private JButton compteur ;
    private JLabel texte_base, texte_clics ;
    private static int nb_clic = 0 ;
}
    
public class D_Label_et_bouton {
    public static void main(String[] args) {
        Fenetre ma_fenetre = new Fenetre() ;
        ma_fenetre.setVisible(true);
    }    
}
