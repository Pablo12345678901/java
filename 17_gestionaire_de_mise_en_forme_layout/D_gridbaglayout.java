//package ZZZ_Ressources_livres.chap17;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

/* Ce programme affiche un drapeau Suisse (carré avec croix) sur tout l'écran */

class MaFenetre extends JFrame {
    public static int NBOUTONS = 10 ;
    //                         { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}
    public static int x[] =    { 0, 2, 3, 0, 1, 2, 3, 4, 0, 2, 3, 2, 2} ;
    public static int y[] =    { 0, 0, 0, 2, 2, 2, 2, 2, 3, 4, 3, 1, 3} ;
    public static int larg[] = { 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1} ;
    public static int haut[] = { 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1} ;
    public static int px [] =  { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0} ;
    public static int py [] =  { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1} ;
    public JPanel [] panneaux = new JPanel [x.length];

    public MaFenetre ()
    {   setTitle ("Exemple GridBagLayout") ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        Dimension taille = Toolkit.getDefaultToolkit().getScreenSize() ;
        int taille_x = taille.width ;
        int taille_y = taille.height ;
        int taille_min = Math.min(taille_x, taille_y) ;
        int taille_max = Math.max(taille_x, taille_y) ;
        int marge = (int)((taille_max-taille_min)/2) ;
        // Calcul des marges pour que le drapeau soit centré
        if (taille_x == taille_min)
        {   setBounds(0, marge, taille_min, taille_min) ;
        }
        else if (taille_y == taille_min)
        {   setBounds(marge, 0, taille_min, taille_min) ;
        }
        // Fixation de la taille de la fenêtre
        setMinimumSize(new Dimension(taille_min, taille_min)) ;
        setMaximumSize(new Dimension(taille_min, taille_min)) ;

        Container contenu = getContentPane() ;

        GridBagLayout g = new GridBagLayout() ;
        contenu.setLayout (g) ;
        GridBagConstraints c = new GridBagConstraints() ;
        c.fill = c.BOTH ;
        
        for (int i = 0 ; i<x.length ; i++)
        {   c.gridx = x[i] ; c.gridy = y[i] ;
            c.gridwidth = larg[i] ; c.gridheight = haut[i] ;
            c.weightx = px[i] ; c.weighty = py[i] ;
            panneaux[i] = new JPanel() ;
            if ((i>=4 && i<=6) || i>10)
            {   panneaux[i].setBackground(Color.white) ;
            }
            else
            {   panneaux[i].setBackground(Color.red) ;
            }
            contenu.add (panneaux[i], c) ;
        }
    }
}

public class D_gridbaglayout {
    public static void main (String args[])
    { MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}
