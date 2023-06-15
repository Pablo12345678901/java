import java.awt.* ;   // pour Desktop
import java.io.* ;    // pour IOException
import java.net.*;    // pour URI 

public class BtestDeskTop 
{  public static void main (String[] args)throws URISyntaxException, IOException
    {  if (Desktop.isDesktopSupported())System.out.println ("Desktop supporte");
                                    else { System.out.println ("Desktop non supporte") ;
                                        System.exit(-1) ;
                                        }
            // d�finitions des diff�rentes informations � compl�ter :
            //   url, adresse mail, nom fichier (xxxxxx) et type (ttt), message
        URI adresseWeb = new URI("http://www.google.com") ; 
        File fichier = new File ("test.txt") ;   // fichier local au dossier - path relatif
        String message = "salut" ;

        URI uriMail= new URI ("mailto:pablo.zamora@outlook.fr", message, null) ;   
        
        Desktop bureau = Desktop.getDesktop() ;
        if (bureau.isSupported(Desktop.Action.BROWSE))
        {   System.out.println ("BROWSE accepte") ;
            bureau.browse(adresseWeb) ;  // peut d�clencher une IOException
            System.out.println("Ouverture du navigateur en page : " + adresseWeb.toString() + " - Taper enter pour continuer le programme.") ;
            System.in.read();            // pour cr�er une attente
        }

        // Ne fonctionne pas car j'ai supprimé l'applcation mail de Mac et ne fonctionne qu'avec les app par défaut
        if (bureau.isSupported(Desktop.Action.MAIL))
        {   System.out.println ("MAIL accepte") ;
            bureau.mail (uriMail) ;
            System.out.println("Envoi de l'e-mail " + message + " - Taper enter pour continuer le programme.") ;
            System.in.read();            // pour cr�er une attente
        }

        if (bureau.isSupported(Desktop.Action.OPEN))
        {   System.out.println ("OPEN accepte") ;
            bureau.open(fichier) ;
            System.out.println("Ouverture du fichier : " + fichier.getName() + " - Taper enter pour continuer le programme.") ;
            System.in.read();            // pour cr�er une attente
        }

        if (bureau.isSupported(Desktop.Action.PRINT))
        {   System.out.println ("PRINT accepte") ;
            bureau.print(fichier) ;
            System.out.println("Impression du fichier : " + fichier.getName() + " - Taper enter pour continuer le programme.") ;
            System.in.read();            // pour cr�er une attente
        }

        System.out.println("Fin du programme") ;
        System.exit(1) ;
  }
}