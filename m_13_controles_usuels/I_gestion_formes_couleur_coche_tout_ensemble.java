import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

class MaFenetre extends JFrame implements ActionListener, ItemListener, FocusListener
{   static public final String[] nomCouleurs = {"rouge", "vert", "jaune", "bleu"} ;
    static public final Color[] couleurs = {Color.red, Color.green, Color.yellow, Color.blue} ;
    public MaFenetre ()
    {   setTitle ("FIGURES") ;
        setSize (700, 500) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contenu = getContentPane() ;
        /*** paneau pour les dessins ***/
        panDes = new PaneauDessin(this) ; // class à part car possède méthode d'affichage rectangle, ovale +  modif hauteur, largeur et couleur (+ repaint)
        contenu.add(panDes) ; // par défaut au milieu
        panDes.setBackground(Color.blue) ;  // paneau initialement bleu
        /*** paneau pour les commandes ***/
        panCom = new JPanel() ;
        contenu.add (panCom, "South") ;
            /* choix couleur */
        comboCoulFond = new JComboBox (nomCouleurs) ;
        comboCoulFond.setSelectedIndex(3);
        panCom.add(comboCoulFond) ;
        comboCoulFond.addItemListener(this) ; 
            /* choix dimensions */
        JLabel dim_x = new JLabel ("LARGEUR") ;
        panCom.add (dim_x) ;
        String taille_base = "" + 100 ;
        txtLargeur = new JTextField (taille_base, 5) ;
        txtLargeur.addActionListener(this) ;
        txtLargeur.addFocusListener(this) ;
        panCom.add (txtLargeur) ;
        JLabel dim_y = new JLabel ("HAUTEUR") ;
        panCom.add (dim_y) ;
        txtHauteur = new JTextField (taille_base, 5) ;
        panCom.add (txtHauteur) ;
        txtHauteur.addActionListener(this) ;
        txtHauteur.addFocusListener(this) ;
            /* choix formes */
        cOvale = new JCheckBox ("Ovale") ;
        panCom.add (cOvale) ;
        cOvale.addActionListener(this) ;
        cRectangle = new JCheckBox ("Rectangle") ;
        panCom.add (cRectangle) ;
        cRectangle.addActionListener(this) ;
    }
    public void actionPerformed (ActionEvent ev)
    {   if (ev.getSource() == txtLargeur) setLargeur() ; 
        else if (ev.getSource() == txtHauteur) setHauteur() ;
        else if (ev.getSource() == cOvale)
        {   setLargeur() ;
            setHauteur() ;
            panDes.setOvale(cOvale.isSelected()) ;
        }
        else if (ev.getSource() == cRectangle)
        {   setLargeur() ;
            setHauteur() ;
            panDes.setRectangle(cRectangle.isSelected()) ;
        }
        panDes.repaint() ;
    }
    public void focusLost   (FocusEvent e)
    {   if (e.getSource() == txtLargeur)
        { setLargeur() ;
        System.out.println ("perte focus largeur") ;
        panDes.repaint() ;
        }
        if (e.getSource() == txtHauteur)
        { setHauteur() ;
        panDes.repaint() ;
        }
    }
    public void focusGained (FocusEvent e){ // protection contre les exceptions de début (saisie mauvaise valeur avant activation des coches des formes)
        setLargeur () ;
        last_largeur = panDes.getLargeur() ;
        setHauteur() ;
        last_hauteur = panDes.getHauteur() ;
    }
    
    private void setLargeur() // Inclus gestion des exceptions (nombre négatif ou non nombre)
    {   String ch = txtLargeur.getText() ;
        System.out.println ("largeur " + ch) ;
        try
        {   last_largeur = panDes.getLargeur() ;
            if (Integer.parseInt(ch) <= 0)
            {   throw new Exception() ;
            }
            panDes.setLargeur (Integer.parseInt(ch)) ;
        }
        catch (NumberFormatException e)
        {   System.out.println(e.toString()) ;
            System.out.println("ERREUR : valeur invalide, veuillez saisir un nombre.") ;
            panDes.setLargeur (last_largeur) ;
        }
        catch (Exception e)
        { System.out.println("ERREUR : valeur invalide, veuillez saisir un nombre > 0.") ;
        }
    }
    private void setHauteur() // Inclus gestion des exceptions (nombre négatif ou non nombre)
    {   String ch = txtHauteur.getText() ; // Gérer l'exception
        System.out.println ("hauteur " + ch) ;
        try
        {   last_hauteur = panDes.getHauteur() ;
            if (Integer.parseInt(ch) <= 0)
            {   throw new Exception() ;
            }
            panDes.setHauteur (Integer.parseInt(ch)) ;
        }
        catch (NumberFormatException e)
        {   System.out.println(e.toString()) ;
            System.out.println("ERREUR : valeur invalide, veuillez saisir un nombre.") ;
            panDes.setHauteur(last_hauteur) ;
        }
        catch (Exception e)
        { System.out.println("ERREUR : valeur invalide, veuillez saisir un nombre > 0.") ;
        }
    }
    public void itemStateChanged(ItemEvent e)
    {   if (!(couleur == (String)comboCoulFond.getSelectedItem()))
        {   //DEBUG System.out.println("Appel : itemStateChanged") ;
            couleur = (String)comboCoulFond.getSelectedItem() ;
            panDes.setCouleur (couleur) ;
        }     
    }
    private PaneauDessin panDes ;
    private JPanel panCom ;
    private JComboBox comboCoulFond ;
    private JTextField txtLargeur, txtHauteur ;
    private JCheckBox cOvale, cRectangle ;
    private String couleur ;
    private int last_hauteur, last_largeur ;
}

class PaneauDessin extends JPanel
{   public PaneauDessin(MaFenetre fen)
    {   super() ;
        this.fen = fen ;
    }
    public void paintComponent(Graphics g)
    { super.paintComponent(g) ;
        Dimension dim_fen = fen.getSize() ;
        int marge_x = (dim_fen.width - largeur) / 2 ;
        int marge_y = (dim_fen.height - hauteur) / 2 ;
    if (ovale)     g.drawOval (marge_x, marge_y, largeur, hauteur) ;
    if (rectangle) g.drawRect (marge_x, marge_y, largeur, hauteur) ;
    }
    public void setRectangle(boolean b) { rectangle = b ; }
    public void setOvale(boolean b)     { ovale = b ;  }
    public void setLargeur (int l) { largeur = l ; }
    public void setHauteur (int h) { hauteur = h ; }
    public void setCouleur (String c)
    {   for (int i = 0 ; i<MaFenetre.nomCouleurs.length ; i++)
            if (c == MaFenetre.nomCouleurs[i])
            {   setBackground (MaFenetre.couleurs[i]) ;
                break ;
            }
    }
    public int getHauteur() { return hauteur ;}
    public int getLargeur() { return largeur ;}
    private MaFenetre fen ;
    private boolean rectangle = false, ovale = false ;
    private int largeur, hauteur ;
}

public class I_gestion_formes_couleur_coche_tout_ensemble {
    public static void main (String args[])
    { MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}
