import java.io.* ;
import java.net.* ;

// Problème de thread qui reste bloqué sur le readline()
// Et problème de non arrêt de tous les thread en même temps
// 2 threads des 2 classes actifs en même temps

public class F_socket_client
{   public static void main(String[] args) throws IOException
    {   String hote = "127.0.0.1" ;
        int port = 1000 ;
        Socket soc = new Socket(hote, port) ;

        boolean encours = true ;
        ThrInput input = new ThrInput(soc, encours) ;
        input.start();
        ThrOutput output = new ThrOutput(soc, encours) ;
        output.start();

        // A GERE APRES POUR LA CONDITION DE FERMETURE DE LA SERVEURSOCKET
        while (encours)
        { System.out.print("") ;
        }
        try
        {   soc.close() ;
            System.out.println("Fermeture socket") ;
        }
        catch (IOException e)
        {   System.out.println("IOException lors de fermeture socket") ;
            System.exit(0) ;
        }
        System.out.println("Fin du programme.") ;
    }
}


