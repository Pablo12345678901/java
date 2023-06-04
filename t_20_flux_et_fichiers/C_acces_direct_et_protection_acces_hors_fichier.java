import java.io.* ;

public class C_acces_direct_et_protection_acces_hors_fichier
{ public static void main (String args[]) throws IOException
  {
    String nomfich ;
    int n, num ;
    RandomAccessFile entree ;
    System.out.print ("donnez le nom du fichier a consulter : ") ;
    nomfich = Clavier.lireString() ;
    entree = new RandomAccessFile (nomfich, "r") ;
    long taille = entree.length() ;
    System.out.println("Taille de : " + taille + " octets.") ;

    do
    {   System.out.print ("Numero de l'entier recherche : ") ;
        num = Clavier.lireInt() ;
        if (num == 0) break ;
        long rang = 4*(num-1) ;
        try
        {   if ( (rang<0) || (rang>taille) ) throw new Exception() ;
            if (num*Integer.BYTES>taille)
            {   System.out.println("Dans fichier mais sur le dernier entier.") ;
                throw new Exception() ;
            }
        }
        catch (Exception e)
        {   System.out.println ("entier inexistant") ;
            continue ;
        }
        entree.seek (rang) ;
        n = entree.readInt() ;
        System.out.println ("  valeur = " + n) ;
    }
    while (num != 0) ;

    entree.close () ;
    System.out.println ("*** fin consultation fichier ***");
  }
}
