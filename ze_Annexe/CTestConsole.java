import java.io.* ;

public class CTestConsole
{   public static void main (String args[])
    {   Console cons = System.console();
        if (cons == null)   {   System.out.println ("pas de console") ;  // sur System.out
                                System.exit(-1) ;
                            } 
        else System.out.println ("il y a une console") ;          // sur System.out 
        
        System.out.println("Tapez du texte qui sera lu comme mot de passe (non visible à l'écran lors de la saisie)") ;
        System.out.print("-> ") ;
        char pass [] = cons.readPassword() ;
        System.out.print ("Mot de passe fourni : ") ;                // echo password
        for (char c : pass) System.out.print (c) ;
        System.out.println() ;
    
        PrintWriter wcon = cons.writer() ;   // wcon = PrintWriter associe a la console
        wcon.println ("quelques caractères à problème sur console : éàèç") ; 
        System.out.println ("quelques caractères à problème sur out : éàèç") ;  

        wcon.println ("donnez une ligne de texte : ") ;
        String ligne = new String() ;                 // pour lire une ligne au clavier
        ligne = cons.readLine() ;                     // lecture une ligne sur console
        wcon.println ("on a lu \"" + ligne + "\"") ;       //  affichage sur console
        System.out.println ("on a lu \"" + ligne + "\"") ; //    puis sur System.out
    }
}