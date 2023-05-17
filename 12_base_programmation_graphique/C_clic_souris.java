import javax.swing.*;
import java.awt.event.*; // pour les évènement de la souris

public class C_clic_souris {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}

class MaFenetre extends JFrame implements MouseListener {
    public MaFenetre()
    {   setBounds(10, 40, 700, 500);
        setTitle("Titre de la fenêtre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e)
    { System.out.println("Clic sur la fenêtre") ;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e)
    {   System.out.println("Souris appuyée") ;
    }  
    public void mouseReleased(MouseEvent e)
    {   System.out.println("Souris relâchée") ;
    }  
}

