import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class O_plusieurs_boutons_aggrandir_rapetisser {
    public static void main(String[] args) {
        System.out.println("Début") ;
        MyWindows Mafenetre = new MyWindows(200) ;
        Mafenetre.setVisible(true);
    }
}

class MyWindows extends JFrame implements ActionListener {
    public MyWindows(int marge)
    {   Toolkit tk = Toolkit.getDefaultToolkit() ;
        Dimension dimension = tk.getScreenSize() ;
        // paramètres fenêtre
        setBounds(marge, marge, dimension.width-2*marge, dimension.height-2*marge);
        setTitle("Gestion taille boutons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // création container
        Container container = getContentPane() ;
        container.setLayout(new FlowLayout());
        aggrandir = new JButton("+") ;
        rapetisser = new JButton("-") ;
        bouton_1 = new JButton("bouton_1") ;
        bouton_1.setMinimumSize(new Dimension(100, 100));
        bouton_1.setMaximumSize(new Dimension(1000, 1000));
        bouton_2 = new JButton("bouton_2") ;
        bouton_2.setMinimumSize(new Dimension(100, 100));
        bouton_1.setMaximumSize(new Dimension(1000, 1000));
        container.add(aggrandir) ;
        container.add(rapetisser) ;
        container.add(bouton_1) ;
        container.add(bouton_2) ;
        aggrandir.addActionListener(this);
        rapetisser.addActionListener(this);
        bouton_1.addActionListener(this);
        bouton_2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ev)
    {   if (ev.getSource() == aggrandir)
        {   variation_x = 10 ; variation_y = 10 ;
        }
        else if (ev.getSource() == rapetisser)
        {  variation_x = -10 ; variation_y = -10 ;
        }
        else if (ev.getSource() == bouton_1 || ev.getSource() == bouton_2)
        {   JButton bouton_x = (JButton) ev.getSource() ;
            dim_bouton = bouton_x.getSize() ;
            // gestion taille x
            if (dim_bouton.width + variation_x < dim_max.width && dim_bouton.width + variation_x > dim_min.width)
            {   dim_bouton.width += variation_x ;
            }
            else if (dim_bouton.width + variation_x >= dim_max.width)
            {   dim_bouton.width = dim_max.width ;
            }
            else if (dim_bouton.width + variation_x <= dim_min.width)
            {   dim_bouton.width = dim_min.width ;
            }
            // gestion taille y
            if (dim_bouton.height + variation_y < dim_max.height && dim_bouton.height + variation_y > dim_min.height)
            {   dim_bouton.height += variation_y ;
            }
            else if (dim_bouton.height + variation_y >= dim_max.height)
            {   dim_bouton.height = dim_max.height ;
            }
            else if (dim_bouton.height + variation_y <= dim_min.height)
            {   dim_bouton.height = dim_min.height ;
            }
            bouton_x.setPreferredSize(dim_bouton);
            System.out.println("Bouton : " + bouton_x.getText() + " x y " + dim_bouton.width + " " + dim_bouton.height) ;
            bouton_x.revalidate() ;
        }
        else System.out.println("ERREUR - source inconnue") ;
    }
    private JButton aggrandir, rapetisser, bouton_1, bouton_2 ;
    private int variation_x = 0, variation_y = 0 ;
    private Dimension dim_bouton ;
    private Dimension dim_min = new Dimension(10, 10);
    private Dimension dim_max = new Dimension(300, 300);
}