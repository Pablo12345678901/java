import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class L_traces_de_clics {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}

class MaFenetre extends JFrame {
    public MaFenetre()
    {   // paramètres fenêtre
        setBounds(10, 40, 700, 500);
        setTitle("Clic et dessine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panneau de couleur
        panneau = new JPanel() ;
        Color color = new Color(0.9f, 0.9f, 0.24f) ;
        panneau.setBackground(color);
        // création container
        Container container = getContentPane() ;
        container.add(panneau) ;
        panneau.addMouseListener(new ClicSouris(panneau));
    }
    private JPanel panneau ;
}

class ClicSouris extends MouseAdapter {
    public ClicSouris(JPanel panneau)
    { this.panneau = panneau ;
    }
    public void mouseClicked(MouseEvent e)
    {   System.out.println("Clic " + (++nb_clic)) ;
        x = e.getX() ;
        y = e.getY() ;
        Graphics g = panneau.getGraphics();
        g.drawRect(x-2, y-2, 4, 4) ;
        g.dispose() ;
        pressed = false ;
    }
    public void mousePressed(MouseEvent e)
    {   System.out.println("Press " + (++nb_clic)) ;
        x = e.getX() ;
        y = e.getY() ;
        pressed = true ;
    }
    public void mouseReleased(MouseEvent e)
    {   if (pressed)
        {   System.out.println("Released ") ;
            Graphics g = panneau.getGraphics();
            g.drawRect(x-2, y-2, 4, 4) ;
            g.dispose() ;
        }
        pressed = false ;
    }
    private int x, y ;
    private static int nb_clic = 0 ;
    private JPanel panneau ;
    private boolean pressed = false ;
}