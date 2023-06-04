package zzz_ressources_livres.chap10;
public class ExcStd2
{ public static void main (String args[])
  { int t[] ;
    System.out.print ("taille voulue : ") ;
    int n = Clavier.lireInt() ;
    t = new int[n] ;
    System.out.print ("indice : ") ;
    int i = Clavier.lireInt() ;
    t[i] = 12 ;
    System.out.println ("*** fin normale") ;
  }
}


