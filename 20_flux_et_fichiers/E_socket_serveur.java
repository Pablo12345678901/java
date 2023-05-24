import java.io.* ;
import java.net.* ;
import ThrInput ;
import ThrOutput ;

public class E_socket_serveur
{   public static void main(String[] args) throws IOException
    {   int port = 1000 ;
        ServerSocket sersoc = new ServerSocket(port) ;
        System.out.println("Serveur activé sur port " + port) ;
        Socket soc = sersoc.accept() ;

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
        sersoc.close() ;
        System.out.println("Fin du programme.") ;
    }
    
}

/* 
class ThrInput extends Thread
{   public ThrInput(Socket soc, boolean encours_input)
    {   this.soc = soc ;
        this.encours_input = encours_input ;
        try
        {flux_i = soc.getInputStream() ;
        }
        catch (IOException e)
        {   System.out.println("IOException du thread ThrInput") ;
            System.exit(0) ;
        }
        entree = new BufferedReader(new InputStreamReader(flux_i)) ;
    }
    public void run()
    {   while (!interrupted())
        {   try
            {   if ((message = entree.readLine()) != null) System.out.println("Message reçu : " + message) ;
                else
                {   soc.close() ;
                    System.out.println("Fermeture socket du thread ThrInput") ;
                    throw new InterruptedException() ;
                }
            }
            catch (InterruptedException e)
            {   System.out.println("InterruptedException du thread ThrInput") ;
                encours_input = false ;
                return ;
            }
            catch (IOException e)
            {   System.out.println("IOException du thread ThrInput") ;
                encours_input = false ;
                return ;
            }
        } 
    }
    private InputStream flux_i ;
    private BufferedReader entree ;
    private Socket soc ;
    private String message = null ;
    private boolean encours_input ;
}

class ThrOutput extends Thread
{   public ThrOutput(Socket soc, boolean encours_output)
    {   this.soc = soc ;
        this.encours_output = encours_output ;
        try
        {   flux_o = soc.getOutputStream() ;
        }
        catch (IOException e)
        {   System.out.println("IOException du thread ThrOutput") ;
            System.exit(0) ;
        }
        sortie = new OutputStreamWriter(flux_o) ;
    }
    public void run()
    {   while (!interrupted())
        {   try
            {   System.out.println("Votre message (enter avec ligne vide pour stopper) : ") ;
                message = Clavier.lireString() ;
                if (message.length() == 0)
                {   soc.close() ;
                    System.out.println("Fermeture socket du thread ThrOutput") ;
                    throw new InterruptedException() ;
                }
                else
                {   sortie.write(message+"\n") ;
                    sortie.flush() ; // pour forcer le vidage du flux et donc l'envoi du message
                }
            }
            catch (InterruptedException e)
            {   System.out.println("InterruptedException du thread ThrOutput") ;
                encours_output = false ;
                return ;
            }
            catch (IOException e)
            {   System.out.println("IOException du thread ThrOutput") ;
                encours_output = false ;
                return ;
            }
        } 
    }
    private OutputStream flux_o;
    private OutputStreamWriter sortie ;
    private Socket soc ;
    private String message = null ;
    private boolean encours_output ;
}
*/