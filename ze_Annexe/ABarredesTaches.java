import java.awt.* ;
import javax.swing.* ;
import java.io.* ;

public class ABarredesTaches 
{   public static void main (String args[]) throws AWTException, IOException
    {   if (SystemTray.isSupported()) System.out.println ("SystemTray OK");
        else {  System.out.println ("SystemTray pas supporte");
                System.exit(-1);
                } 
        ImageIcon im1 = new ImageIcon ("rouge.gif") ;   
        Image image1 = im1.getImage();
        TrayIcon tic1 = new TrayIcon (image1, "Rouge : Texte d'information modifiable dans le code") ;
        SystemTray tray = SystemTray.getSystemTray();
        tray.add(tic1) ;
        System.out.println("Ajout icone rouge - Taper enter pour continuer le programme...") ;
        Clavier.lireString () ;   // pour provoquer une attente utilisateur
        ImageIcon im2 = new ImageIcon ("vert.gif") ; 
        Image image2 = im2.getImage();
        TrayIcon tic2 = new TrayIcon (image2, "Vert : Texte d'information modifiable dans le code") ;
        tray.add(tic2) ;
        System.out.println("Ajout icone verte - Taper enter pour continuer le programme...") ;
        Clavier.lireString () ;    // nouvelle attente
        tray.remove(tic1) ;  // suppression premi�re ic�ne
        System.out.println("Supression icone rouge - Taper enter pour continuer le programme...") ;
        Clavier.lireString () ;    // derni�re attente    
        tray.remove(tic2) ; 
        System.out.println("Supression icone verte - Fin du programme.") ;      
        System.exit(1) ;   
   }
}
