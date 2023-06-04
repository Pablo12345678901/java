import java.io.* ;
import java.net.* ;

// Problème de thread qui reste bloqué sur le readline()
// Et problème de non arrêt de tous les thread en même temps
// 2 threads des 2 classes actifs en même temps

public class EF_thread_input_and_output {
    public static void main(String[] args) {
        int i = 0 ;
    }
}

class ThrInput extends Thread
{   public ThrInput(Socket soc, boolean encours)
    {   this.soc = soc ;
        this.encours = encours ;
        try
        {   flux_i = soc.getInputStream() ;
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
            {   if (!encours)
                {   this.interrupt() ;
                }
                if ((message = entree.readLine()) != null) System.out.println("Message reçu : " + message) ;
                else
                {   throw new InterruptedException() ;
                }
            }
            catch (InterruptedException e)
            {   System.out.println("InterruptedException du thread ThrInput") ;
                encours = false ;
                return ;
            }
            catch (IOException e)
            {   System.out.println("IOException du thread ThrInput") ;
                encours = false ;
                return ;
            }
        } 
    }
    private InputStream flux_i ;
    private BufferedReader entree ;
    private Socket soc ;
    private String message = null ;
    private boolean encours ;
}

class ThrOutput extends Thread
{   public ThrOutput(Socket soc, boolean encours)
    {   this.soc = soc ;
        this.encours = encours ;
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
            {   if (!encours)
                {   this.interrupt() ;
                }
                System.out.println("Votre message (enter avec ligne vide pour stopper) : ") ;
                message = Clavier.lireString() ;
                if (message.length() == 0)
                {   throw new InterruptedException() ;
                }
                else
                {   sortie.write(message+"\n") ;
                    sortie.flush() ; // pour forcer le vidage du flux et donc l'envoi du message
                }
            }
            catch (InterruptedException e)
            {   System.out.println("InterruptedException du thread ThrOutput") ;
                encours = false ;
                return ;
            }
            catch (IOException e)
            {   System.out.println("IOException du thread ThrOutput") ;
                encours = false ;
                return ;
            }
        }
    }
    private OutputStream flux_o;
    private OutputStreamWriter sortie ;
    private Socket soc ;
    private String message = null ;
    private boolean encours ;
}
