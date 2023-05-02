package ZZZ_Ressources_livres.chap11;
public class TstThr1
{ public static void main (String args[])
  { Ecrit e1 = new Ecrit ("bonjour ", 10, 5) ;
    Ecrit e2 = new Ecrit ("bonsoir ", 12, 10) ;
    Ecrit e3 = new Ecrit ("\n", 5, 15) ;
    e1.start() ;
    e2.start() ;
    e3.start() ;
    Clavier.lireInt();
  }
}
class Ecrit extends Thread
{ public Ecrit (String texte, int nb, long attente)
  { this.texte = texte ;
    this.nb = nb ;
    this.attente = attente ;
  }
  public void run ()
  {  try
     { for (int i=0 ; i<nb ; i++)
       { System.out.print (texte) ;
         sleep (attente) ;
       }
     }
     catch (InterruptedException e) {}  // impose par sleep
  }
  private String texte ;
  private int nb ;
  private long attente ;
}

/*
bonjour bonsoir bonjour
bonsoir bonjour bonjour bonsoir bonjour
bonjour bonsoir bonjour
bonjour bonsoir bonjour
bonjour bonsoir bonsoir
bonsoir bonsoir bonsoir bonsoir bonsoir
*/
