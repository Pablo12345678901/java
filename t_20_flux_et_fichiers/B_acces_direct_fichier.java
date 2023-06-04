import java.io.* ;

public class B_acces_direct_fichier
{ public static void main (String args[]) throws IOException
  {
    String nomfich ;
    int n, num ;
    RandomAccessFile entree ;
    System.out.print ("donnez le nom du fichier a consulter : ") ;
    nomfich = Clavier.lireString() ;
    entree = new RandomAccessFile (nomfich, "r") ;

    do
     { System.out.print ("Index de l'entier recherché (premier index = 1): ") ;
       num = Clavier.lireInt() ;
       if (num == 0) break ;
       entree.seek (Integer.BYTES*(num-1)) ; // Integer.BYTES fourni la taille en octet d'un int (équivalent de sizeof en C++)
       n = entree.readInt() ;
       System.out.println ("  valeur = " + n) ;
    }
    while (num != 0) ;

    entree.close () ;
    System.out.println ("*** fin consultation fichier ***");
  }
}
