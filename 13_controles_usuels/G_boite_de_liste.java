import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.* ;

class Fenetre extends JFrame implements ListSelectionListener {
    public Fenetre() {
        setBounds(0, 300, 400, 500);
        setTitle("Boîte de liste à choix multiples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
    
        titre = new JLabel("Pour une sélection de plage,\nCliquez sur le début de la plage puis maintenez MAJ et cliquez sur la fin de la plage\nPour sélectionner plusieurs plages,\nmaintenez CONTROL enfoncé tout du long.") ;
        contenu.add(titre) ;

        System.out.println("Combien de charactères aimeriez-vous connaître ? ") ;
        int taille_tableau = Clavier.lireInt() ;
        nombres = new String [taille_tableau] ;
        for (int i=33; i<taille_tableau ; i++) nombres[i-33] = "Char n°" + i + " en hex : " + Integer.toHexString(i) + "  =   " + (char)i; // remplissage tableau (premier char valide = n°23)
        liste = new JList(nombres) ;
        liste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        liste.setSelectedIndex(0); // présélection du 11ème index (valeur = 10)
        liste.addListSelectionListener(this);
        liste.setVisibleRowCount(10); // seules x lignes à la fois seront visibles
        defilement = new JScrollPane(liste) ;
        contenu.add(defilement) ;   
    }

    public void valueChanged(ListSelectionEvent e)
    { if (!e.getValueIsAdjusting())
        {   int i=0 ;
            System.out.println("Nouvelle sélection : ") ;
            liste_choix = liste.getSelectedValues() ;
            liste_index = liste.getSelectedIndices() ;
            for (Object choix : liste_choix) System.out.println("" + liste_index[i++] + ". " + (String) choix) ;
        }
    }

    private JLabel titre ;
    private String [] nombres ;
    private JList liste ;
    private Object liste_choix [] ;
    private int liste_index [] ;
    private JScrollPane defilement ;
    
}
    
public class G_boite_de_liste {
    public static void main(String[] args) {
        Fenetre ma_fenetre = new Fenetre() ;
        ma_fenetre.setVisible(true);
    }    
}
