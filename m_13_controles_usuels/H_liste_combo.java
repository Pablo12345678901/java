import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.* ;


class FenCombo extends JFrame implements ActionListener
{ public FenCombo()
  { setTitle ("Liste Combo") ;
    setSize (300, 200) ;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout() ) ;
    combo = new JComboBox(couleurs) ;
    combo.setEditable (true) ;
    combo.setMaximumRowCount(5);
    contenu.add(combo) ;
    combo.addActionListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object valeur = combo.getSelectedItem() ;
    int rang = combo.getSelectedIndex() ;
    //DEBUG System.out.println("Rang : " + rang) ;
    if (rang == -1)
       {   System.out.println ("Saisie nouvelle valeur : " + valeur) ;
            combo.addItem (valeur) ;
            nouveau = true ;
        }
    else{  if (nouveau)
            { nouveau = false ;
            }
            else System.out.println ("Sélection valeur existante : " + valeur + " de rang : " + rang) ;
        } ;
  }
  private String[] couleurs = {"rouge", "bleu", "gris", "vert", "jaune", "noir" } ;
  private JComboBox combo ;
  private static boolean nouveau ;
}

public class H_liste_combo {
    public static void main (String args[])
    { FenCombo fen = new FenCombo() ;
        fen.setVisible(true) ;
    }
}

 /*boolean nouveau = true ;
         
            for (String couleur : couleurs)
            
            {if (couleur == valeur)
                {   System.out.println("La valeur saisie fait déjà partie de la liste.") ;
                    nouveau = false ;
                    break ;
                }
            }
            
        if (nouveau)    
        */