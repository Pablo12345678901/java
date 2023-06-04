import javax.swing.*;
import java.awt.*; // pour les évènement de la souris / et pour le conteneur
import java.awt.event.*;

public class H_test_plusieurs_boutons_et_actions {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true); // doit etre a la fin des instructions sinon les éléments du conteneur ne s'afficheront qu'après redimension de la fenetre
    }
}
            
class MaFenetre extends JFrame implements ActionListener {
    public MaFenetre()
    {   setBounds(10, 40, 700, 500);
        setTitle("Mon premier bouton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane() ;
        container.setLayout(new FlowLayout());
        System.out.println("Combien de boutons aimeriez-vous ? ") ;
        this.nb_bouton = Clavier.lireInt() ;
        tab_bouton = new Bouton[nb_bouton];
        for (int i=0; i<nb_bouton; i++)
        {   Bouton bouton = new Bouton("" + (i+1) + " - cliquez", ++bouton_courant) ;
            tab_bouton[i] = bouton ;
            container.add(tab_bouton[i]) ;
            tab_bouton[i].addActionListener(this) ;
        }
    }
    public void actionPerformed(ActionEvent ev)
    {   if (ev.getSource() instanceof Bouton)
        {   Bouton bouton_x = (Bouton) ev.getSource() ;
            bouton_x.setText(bouton_x.num_bouton + " - " + (++bouton_x.nb_clic)); // applique la méthode sur le bon bouton - qu'il y en ait 1 ou 100
        }
        else System.out.println("Erreur : source inconnue ") ;
    }
    private final int nb_bouton ;
    private static int bouton_courant = 0 ;
    private Bouton [] tab_bouton ;
}

class Bouton extends JButton {
    public Bouton(String nom, int num_bouton)
    {   super(nom) ;
        this.num_bouton = num_bouton ;
    }
    public int nb_clic = 0 ;
    public final int num_bouton ;
}
    