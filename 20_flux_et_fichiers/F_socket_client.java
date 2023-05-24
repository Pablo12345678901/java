import java.io.* ;
import java.net.* ;

public class F_socket_client
{   public static void main(String[] args) throws IOException
    {   String hote = "127.0.0.1" ;
        int port = 1000 ;
        Socket soc = new Socket(hote, port) ;

        boolean encours_input = true ;
        ThrInput input = new ThrInput(soc, encours_input) ;
        input.start();
        
        boolean encours_output = true ;
        ThrOutput output = new ThrOutput(soc, encours_output) ;
        output.start();

        // A GERE APRES POUR LA CONDITION DE FERMETURE DE LA SERVEURSOCKET
        while (encours_input && encours_output)
        { System.out.print("") ;
        }

        System.out.println("Fin du programme.") ;
    }
}


