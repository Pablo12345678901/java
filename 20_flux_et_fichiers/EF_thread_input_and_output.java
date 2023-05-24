package 20_flux_et_fichiers ;

import java.io.* ;
import java.net.* ;

public class EF_thread_input_and_output {
    public static void main(String[] args) {
        int i = 0 ;
    }
}

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
