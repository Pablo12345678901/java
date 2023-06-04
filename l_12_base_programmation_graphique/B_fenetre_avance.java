import javax.swing.*;

public class B_fenetre_avance {
    public static void main(String[] args) {
        System.out.println("Début main") ;
        JFrame fen = new JFrame() ;
        fen.setBounds(10, 40, 700, 500); // gestion position et taille fenêtre
        fen.setVisible(true);
        fen.setTitle("Titre de la fenêtre");
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermeture de l'app (exit lors de la fermeture avec la croix)
        //fen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ne ferme pas
        //fen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // par défaut
        //fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // détruit l'objet fenêtre à la fermeture

        // Déplacement de la fenêtre avec un thread
        ThrMouv thmouv = new ThrMouv(fen) ;
        thmouv.start() ;
    }
}

class ThrMouv extends Thread {
    public ThrMouv(JFrame fen)
    {   this.fen = fen ;
    }
    public void run()
    {   int x_ini = 10 ;
        int y_ini = 40 ;
        int dx = 10 ;
        int dy = 30 ;
        try
        {   for (int i=0; i<20; i++)
            {   x_ini+=dx ; y_ini+=dy ;
                fen.setBounds(x_ini, y_ini, 700, 500) ;
                sleep(20) ;
            }
        }
        catch (InterruptedException e)
        { return ;}
        System.out.println("Fin du déplacement") ;
        return ;
    }
    private JFrame fen ;
}