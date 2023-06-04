import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame implements ItemListener, ActionListener {
    public Fenetre() {
        setBounds(0, 300, 400, 100);
        setTitle("2 cases à cocher et affichage de l'état");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        case_1 = new JCheckBox("case 1", false) ;
        contenu.add(case_1) ;
        case_1.addItemListener(this);    
        case_2 = new JCheckBox("case 2", false) ;
        contenu.add(case_2) ;
        case_2.addItemListener(this); 
        etat = new JButton("État") ;
        etat.addActionListener(this);  
        contenu.add(etat) ;
    }
    public void itemStateChanged(ItemEvent e)
    {   JCheckBox case_x = (JCheckBox) e.getSource() ;
        if (case_x == case_1) System.out.println("Action sur case 1 : " + " " + e.getStateChange() + " " + case_1.isSelected()) ; // getStateChange retourne un int : 1 pour SELECTED et 2 pour DESELECTED - états équivalent à getSelected (en même temps, fourni la même valeur)
        else if (case_x == case_2) System.out.println("Action sur case 2 : " + case_2.isSelected()) ;
        else System.out.println("ERREUR : source inconnue") ;
    }
    public void actionPerformed(ActionEvent e)
    {   System.out.println("État :\nCase 1 : " + case_1.isSelected() + "\nCase 2 : " + case_2.isSelected()) ;
    }
    private JCheckBox case_1, case_2 ;
    private JButton etat ;
}


public class A_2_cases_et_un_bouton_d_etat {
    public static void main(String[] args) {
        Fenetre ma_fenetre = new Fenetre() ;
        ma_fenetre.setVisible(true);
    }    
}
