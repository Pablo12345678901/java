import javax.swing.*;
import java.awt.*; // pour les évènement de la souris / et pour le conteneur
import java.awt.event.*;

public class F_plusieurs_boutons_meme_action {
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

        bouton_1 = new JButton("Cliquez1") ;
        bouton_2 = new JButton("Cliquez2") ;
        Container container = getContentPane() ;
        container.setLayout(new FlowLayout());
        container.add(bouton_1) ;
        container.add(bouton_2) ;
        bouton_1.addActionListener(this) ;
        bouton_2.addActionListener(this) ;
    }
    public void actionPerformed(ActionEvent ev)
    {  System.out.println("Nb de clic : " + (++nb_clic));
    }
    public static int nb_clic  = 0 ;
    private JButton bouton_1, bouton_2 ;
}
