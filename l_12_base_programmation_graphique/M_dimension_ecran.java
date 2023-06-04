import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class M_dimension_ecran {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}

class MaFenetre extends JFrame {
    public MaFenetre()
    {   // paramètres fenêtre
        Toolkit tk = Toolkit.getDefaultToolkit() ;
        Dimension dimension = tk.getScreenSize() ;
        int height = dimension.height ;
        int width = dimension.width ;
        setBounds(0, 0, width/2, height);
        setTitle("Fenêtre taille moitié écran");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // création container
        Container container = getContentPane() ;
        // panneau de couleur
        panneau = new JPanel() ;
        Color color = new Color(0.25f, 0.45f, 0.74f) ;
        panneau.setBackground(color);
        container.add(panneau) ;
    }
    private JPanel panneau ;
}