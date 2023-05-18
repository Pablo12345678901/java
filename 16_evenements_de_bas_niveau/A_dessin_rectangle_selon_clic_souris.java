//package ZZZ_Ressources_livres.chap16;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;

class MaFenetre extends JFrame {
    public MaFenetre ()
    {   setTitle ("Dessin rectangle avec souris") ;
        setSize (300, 200) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        paneau = new Paneau() ;
        Container contenu = getContentPane() ;
        contenu.add(paneau) ;
    }
    private JPanel paneau ;
}

class Paneau extends JPanel implements MouseMotionListener {
    public Paneau()
    {   addMouseMotionListener(this) ;
        addMouseListener (new MouseAdapter()
        {   public void mousePressed (MouseEvent e)
            {   mouseisPressed = true ;
                xDeb = e.getX() ;
                yDeb = e.getY() ;
            }
            public void mouseReleased (MouseEvent e)
            {   if (mouseisPressed && mouseisDragged)
                {   xFin = e.getX() ;
                    yFin = e.getY() ;
                    repaint() ;
                }
                mouseisPressed = false ;
                mouseisDragged = false ;
            }
        }) ;
    }
    public void mouseDragged (MouseEvent e)
    {   if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) !=0) // vérifie si c'est bien le clic gauche et pas le clic droit (ou clic central)
        {   mouseisDragged = true ;
            xFin = e.getX() ;
            yFin = e.getY() ;
            repaint() ;
        }
        //DEBUG else System.out.println("Clic droit (ou central) Dragged") ;
    }
    public void mouseMoved (MouseEvent e)
    {}
    public void paintComponent (Graphics g)
    {   super.paintComponent(g) ;
        int xd, xf, yd, yf ;
        xd = Math.min (xDeb, xFin) ; xf = Math.max (xDeb, xFin) ;
        yd = Math.min (yDeb, yFin) ; yf = Math.max (yDeb, yFin) ;
        taille_x = xf-xd ;
        taille_y = yf-yd ;
        g.drawRect (xd, yd, taille_x, taille_y) ;
    }
    private boolean mouseisPressed = false, mouseisDragged = false ;
    private int xDeb, yDeb, xFin, yFin, taille_x, taille_y ;
}

public class A_dessin_rectangle_selon_clic_souris {
    public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
