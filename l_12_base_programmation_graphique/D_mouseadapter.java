import javax.swing.*;
import java.awt.event.*; // pour les évènement de la souris

public class D_mouseadapter {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}

class MaFenetre extends JFrame {
    public MaFenetre()
    {   setBounds(10, 40, 700, 500);
        setTitle("Titre de la fenêtre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() { // avec class anonyme
                public static int nb_clic  = 0 ;
                public void mouseClicked(MouseEvent e)
                {  System.out.println( (++nb_clic) + " clic sur la fenêtre") ;
                }
        });
    }
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
*/
