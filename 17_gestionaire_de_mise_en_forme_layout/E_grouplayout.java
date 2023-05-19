//package ZZZ_Ressources_livres.chap17;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.event.* ;

class MaFenetre extends JFrame {
    public static int NBOUTONS = 7 ;
    public MaFenetre ()
    {   setTitle ("GroupLayout") ;
        setSize (400, 150) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        
        Container contenu = getContentPane() ;
        
        boutons = new JButton[NBOUTONS] ;
        for (int i=0 ; i<NBOUTONS ; i++)
        {   boutons[i] = new JButton ("Bouton " + i) ;
            boutons[i].setMaximumSize(new Dimension(10*i*i+5, 50*i+5)); // pour montrer la taille des boutons qui varie et l'impact sur l'alignement
            // ici, l'alignement est par colonne, donc on aura 2 colonnes de boutons alignés clairement
        }
        
        GroupLayout ges = new GroupLayout (contenu) ;
        contenu.setLayout(ges) ;
        ges.setAutoCreateGaps(true) ; // pour espacer les composants entre eux
        ges.setAutoCreateContainerGaps(true) ; // pour espacer les composants du bord

        // description première colonne suivant les deux axes
        GroupLayout.ParallelGroup col1h = ges.createParallelGroup();
        col1h.addComponent(boutons[0]) ;
        col1h.addComponent(boutons[2]) ; 
        col1h.addComponent(boutons[4]) ;
        col1h.addComponent(boutons[6]) ;
        GroupLayout.SequentialGroup col1v = ges.createSequentialGroup() ;
        col1v.addComponent(boutons[0]) ;
        col1v.addComponent(boutons[2]) ;
        col1v.addComponent(boutons[4]) ;
        col1v.addComponent(boutons[6]) ;

        // description deuxième colonne suivant les deux axes
        GroupLayout.ParallelGroup col2h = ges.createParallelGroup();
        col2h.addComponent(boutons[1]) ;
        col2h.addComponent(boutons[3]) ;
        col2h.addComponent(boutons[5]) ;
        GroupLayout.SequentialGroup col2v = ges.createSequentialGroup() ;
        col2v.addComponent(boutons[1]) ;
        col2v.addComponent(boutons[3]) ;
        col2v.addComponent(boutons[5]) ;
        
        // Rappel :
        // col1h = paralelle avec 0, 2, 4, 6
        // col1v = sequentiel avec 0, 2, 4, 6
        // col2h = paralelle avec 1, 3, 5
        // col2v = sequentiel avec 1, 3, 5
        // Donc ci-dessous : choix séquentiel avec col1h et col2h (qui elles-mêmes sont parallèle)
        // En résumé, les 2 colonnes seront séquentiellement (une à la suite des autres)
        // Mais leurs propres éléments seront parallèle (les uns aux dessus des autres)
        // C'est d'ailleurs la définition d'une colonne
        
        // description horizontale du groupe de colonnes  
        GroupLayout.SequentialGroup hg = ges.createSequentialGroup () ;
        ges.setHorizontalGroup (hg) ;
        hg.addGroup (col1h) ;
        hg.addGroup (col2h) ;
        // description verticale du groupe de colonnes
        GroupLayout.ParallelGroup hv = ges.createParallelGroup () ;
        ges.setVerticalGroup(hv) ;
        hv.addGroup(col1v) ;
        hv.addGroup(col2v) ;
    }   
    private JButton boutons[] ;
}

public class E_grouplayout {
    public static void main (String args[])
    {   MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true) ;
    }
}
