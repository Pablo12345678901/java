import java.io.* ;

public class D_ecriture_et_lecture_fichier_text 
{ public static void main (String args[]) throws IOException
  {
    String nomfich ;
    String uneLigne = "";
    int longueurLigne = 0 ;
    System.out.print ("Donnez le nom du fichier a creer : ") ;
    nomfich = Clavier.lireString() ;
    PrintWriter sortie = new PrintWriter (new BufferedWriter(new FileWriter (nomfich), 10)) ; // Buffer de taille 10 octets = 5 char
    System.out.println("Taper du texte (enter avec ligne vide pour arrêter) : ") ;
    do
    {   uneLigne = Clavier.lireString() ;
        longueurLigne = uneLigne.length() ;
        if (longueurLigne != 0)
        { sortie.println (uneLigne)  ;
        }
    }
    while (longueurLigne != 0) ;
    sortie.close () ;
    System.out.println ("*** fin creation fichier ***");

    String ligne ;
    BufferedReader entree = new BufferedReader (new FileReader (nomfich)) ;
    while ((ligne = entree.readLine())!= null)
    {   System.out.println (ligne) ;
    }
    entree.close () ;
    System.out.println ("*** fin liste fichier ***");
  }
}
