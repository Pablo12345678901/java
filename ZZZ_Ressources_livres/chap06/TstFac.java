package ZZZ_Ressources_livres.chap06;
class Util
{ public static long fac (long n)
  { if (n>1) return (fac(n-1) * n) ;
        else return 1 ;
  }
}
public class TstFac
{ public static void main (String [] args)
  { int n ;
    System.out.print ("donnez un entier positif : ") ;
    n = Clavier.lireInt() ;
    System.out.println ("Voici sa factorielle : " + Util.fac(n) ) ;
  }
}
     
