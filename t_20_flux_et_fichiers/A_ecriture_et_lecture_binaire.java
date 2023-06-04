import java.io.* ;

public class A_ecriture_et_lecture_binaire
{   public static void main (String args[]) throws IOException
    {   String nomfich ;
        int n = 0 ;
        System.out.print ("donnez le nom du fichier a creer : ") ;
        nomfich = Clavier.lireString() ;
        DataOutputStream sortie = new DataOutputStream (new BufferedOutputStream (new FileOutputStream(nomfich))) ;
        do {    System.out.print("donnez un entier : ") ;
                n = Clavier.lireInt() ;
                if (n != 0)
                { sortie.writeInt(n)  ;
                }
        }
        while (n != 0) ;
        sortie.close() ;
        System.out.println("*** fin creation fichier ***");

        DataInputStream entree = new DataInputStream( new BufferedInputStream ( new FileInputStream(nomfich))) ;
        System.out.println("valeurs lues dans le fichier " + nomfich + " :") ;
        boolean eof = false ;  // sera mis a true par exception EOFile
        // 2 façons de boucler
        // /* 
        while (!eof)
        {   try
            {   n = entree.readInt()  ;
            }
            catch (EOFException e)
            {   eof = true ;
            }
            if (!eof) System.out.println(n) ;
        }
        // */
        /* 
        while (true)
        {   try
            {   n = entree.readInt()  ;
            }
            catch (EOFException e)
            {   break ;
            }
            System.out.println(n) ;
        }
        */
        entree.close() ;
        System.out.println("*** fin liste fichier ***");
    }
}