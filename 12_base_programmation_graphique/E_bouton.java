import javax.swing.*;
import java.awt.*; // pour les évènement de la souris / et pour le conteneur
import java.awt.event.*;

public class E_bouton {
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

        bouton = new JButton("Cliquez") ;
        Container container = getContentPane() ;
        container.setLayout(new FlowLayout());
        container.add(bouton) ;
        bouton.addActionListener(this) ;
    }
    public void actionPerformed(ActionEvent ev)
    {  bouton.setText("" + (++nb_clic));
    }
    public static int nb_clic  = 0 ;
    private JButton bouton ;
}



// ou avec usage d'une class à part
// et de addMouseListener(new X()) à la place de addMouseListener(new MouseAdapter() {...}
/* 
class X extends MouseAdapter {
    public static int nb_clic  = 0 ;
    public void mouseClicked(MouseEvent e)
    {  System.out.println( (++nb_clic) + " clic sur la fenêtre") ;
    }
}

// 2 ème version
addMouseListener(new MouseAdapter() { // avec class anonyme
                public static int nb_clic  = 0 ;
                public void mouseClicked(MouseEvent e)
                {  System.out.println( (++nb_clic) + " clic sur la fenêtre") ;
                }
        });
*/

