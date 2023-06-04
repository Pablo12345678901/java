import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class J_trait_sur_panneau {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}

class MaFenetre extends JFrame {
    public MaFenetre()
    {   // paramètres fenêtre
        setBounds(10, 40, 700, 500);
        setTitle("Panneau de couleur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // création container
        Container container = getContentPane() ;
        // panneau de couleur
        panneau = new Panneau() ;
        Color color = new Color(0.9f, 0.9f, 0.24f) ;
        panneau.setBackground(color);
        container.add(panneau) ;
    }
    private JPanel panneau ;
}

class Panneau extends JPanel {
    public void paintComponent (Graphics g)
    {   super.paintComponent(g);
        g.drawLine(50, 200, 300, 50);
    }
}