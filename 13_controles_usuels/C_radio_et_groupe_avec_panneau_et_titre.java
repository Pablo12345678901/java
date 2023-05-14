import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class Fenetre extends JFrame implements ItemListener, ActionListener {
    public Fenetre() {
        setBounds(0, 300, 500, 200);
        setTitle("2 cases à cocher et affichage de l'état");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());

        panneau = new JPanel() ;
        panneau.setPreferredSize(new Dimension(200, 150)) ;
        Color color = new Color(0.6f, 0.69f, 0.89f) ;
        panneau.setBackground(color);
        panneau.setBorder(new TitledBorder("Quel est votre âge ? "));
        contenu.add(panneau) ;

        choix_1 = new JRadioButton("< 18 ans", true) ;
        panneau.add(choix_1) ; 
        choix_1.addActionListener(this); 
        choix_1.addItemListener(this);    
        groupe_age.add(choix_1) ;

        choix_2 = new JRadioButton("18 < âge < 65 ans", false) ;
        panneau.add(choix_2) ;
        choix_2.addActionListener(this); 
        choix_2.addItemListener(this); 
        groupe_age.add(choix_2) ;

        choix_3 = new JRadioButton("> 65 ans", false) ;
        panneau.add(choix_3) ;
        choix_3.addActionListener(this); 
        choix_3.addItemListener(this); 
        groupe_age.add(choix_3) ;
        
        etat = new JButton("État") ;
        etat.addActionListener(this);  
        panneau.add(etat) ;
    }
    public void itemStateChanged(ItemEvent e)
    {   JRadioButton choix_x = (JRadioButton) e.getSource() ;
        if (choix_x == choix_1) System.out.println("Changement choix_1 : " + choix_1.isSelected()) ;
        else if (choix_x == choix_2) System.out.println("Changement choix_2 : " + choix_2.isSelected()) ;
        else if (choix_x == choix_3) System.out.println("Changement choix_3 : " + choix_3.isSelected()) ;
        else System.out.println("ERREUR : ITEM source inconnue") ;
    }
    public void actionPerformed(ActionEvent e)
    {   Object source = e.getSource() ;
        if (source == choix_1) System.out.println("Action Choix_1 : " + choix_1.isSelected()) ;
        else if (source == choix_2) System.out.println("Action choix_2 : " + choix_2.isSelected()) ;
        else if (source == choix_3) System.out.println("Action choix_3 : " + choix_3.isSelected()) ;
        else if (source == etat) System.out.println("État :\nChoix 1 : " + choix_1.isSelected() + "\nChoix 2 : " + choix_2.isSelected() + "\nChoix 3 : " + choix_3.isSelected()) ;
        else System.out.println("ERREUR : ACTION source inconnue") ;
    }
    private JRadioButton choix_1, choix_2, choix_3 ;
    private ButtonGroup groupe_age = new ButtonGroup() ;
    private JButton etat ;
    private JPanel panneau ;
}
    
public class C_radio_et_groupe_avec_panneau_et_titre {
    public static void main(String[] args) {
        Fenetre ma_fenetre = new Fenetre() ;
        ma_fenetre.setVisible(true);
    }    
}


