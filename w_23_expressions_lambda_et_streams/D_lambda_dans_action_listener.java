
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

class FenCoches extends JFrame // Pas besoin de : implements ActionListener
{   public FenCoches ()
    {   setTitle ("Exemple de cases a cocher") ;
        setSize (400, 100) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contenu = getContentPane() ;
        contenu.setLayout (new FlowLayout()) ;

        coche1 = new JCheckBox ("case 1") ;
        contenu.add(coche1) ;
        coche1.addActionListener (ee -> System.out.println ("action case 1")) ; // fonction lambda à la place d'actionPerformed

        coche2 = new JCheckBox ("case 2") ;
        contenu.add(coche2) ;
        coche2.addActionListener (ee -> System.out.println ("action case 2")) ;

        etat = new JButton ("ETAT") ;
        contenu.add(etat) ;
        etat.addActionListener (ee -> System.out.println ("ETAT CASES : " + coche1.isSelected() + " " + coche2.isSelected())) ;
    }
    // Plus besoin d'action performed
    /* 
    public void actionPerformed (ActionEvent ev)
    {   Object source = ev.getSource() ;
        if (source == coche1) 
        if (source == coche2) System.out.println ("action case 2") ;
        if (source == etat)
        System.out.println ("ETAT CASES : " + coche1.isSelected() + " " + coche2.isSelected()) ;
    }
    */
    private JCheckBox coche1, coche2 ;
    private JButton etat ;
}

public class D_lambda_dans_action_listener
{   public static void main (String args[])
    {   FenCoches fen = new FenCoches() ;
        fen.setVisible(true) ;
    }
}