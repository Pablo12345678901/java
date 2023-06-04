import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class N_rectangle_ovale_s_adapte_taille_fenetre {
    public static void main(String[] args) {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}

class MaFenetre extends JFrame implements ActionListener {
    public MaFenetre()
    {   // paramètres fenêtre
        setBounds(10, 40, 700, 500);
        setTitle("Clic et dessine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // création container
        Container container = getContentPane() ;
        // panneau de couleur
        panneau = new Panneau() ;
        Color color = new Color(0.25f, 0.45f, 0.74f) ;
        panneau.setBackground(color);
        container.add(panneau) ;
        ovale = new JButton("Ovale") ;
        rectangle = new JButton("Rectangle") ;
        container.add(ovale,"North") ;
        container.add(rectangle, "South") ;
        ovale.addActionListener(this) ;
        rectangle.addActionListener(this) ;
    }
    public void actionPerformed(ActionEvent ev)
    {  if (ev.getSource() == ovale) panneau.setOval() ;
        else if (ev.getSource() == rectangle) panneau.setRect() ;
        else System.out.println("ERREUR - source inconnue") ;
        panneau.repaint() ;
    }
    private Panneau panneau ;
    private JButton ovale, rectangle ;
}

class Panneau extends JPanel {
    public void paintComponent (Graphics g)
    {   super.paintComponent(g);
        dimension = getSize() ;
        if (ovale) g.drawOval(marge, marge, dimension.width-2*marge, dimension.height-2*marge);
        else if (rectangle) g.drawRect(marge, marge, dimension.width-2*marge, dimension.height-2*marge);
    }
    public void setRect()
    {   rectangle = true ; ovale = false ;
    }
    public void setOval()
    {   rectangle = false ; ovale = true ;
    }
    private boolean rectangle = false, ovale = false ;
    private Dimension dimension ;
    private int marge = 100 ;
}