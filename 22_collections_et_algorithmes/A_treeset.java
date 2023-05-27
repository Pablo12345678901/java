import java.util.* ;

public class A_treeset
{   public static void main (String args[])
    {   int t[] = {2, 5, -6, 2, -8, 9, 5} ;
        TreeSet<Integer> ens = new TreeSet<>() ;
        /* on ajoute des objets de type Integer */
        for (int i=0 ; i< t.length ; i++)
        {   boolean ajoute = ens.add (Integer.valueOf(t[i])) ;
            if (ajoute) System.out.println ("  On ajoute " + t[i]) ;
                    else System.out.println ("  " + t[i] + " est deja present") ;
        }
        System.out.print ("Ensemble en A = ") ; affiche (ens) ;
        /* on supprime un eventuel objet de valeur Integer(5) */
        Integer cinq = Integer.valueOf(5) ;
        boolean enleve = ens.remove (cinq) ;
        if (enleve) System.out.println ("  On a supprime 5") ;
        System.out.print ("Ensemble en B = ") ; affiche (ens) ;
        /* on teste la presence de Integer(5) */
        boolean existe = ens.contains (cinq) ;
        if (!existe) System.out.println ("  On ne trouve pas 5") ;
        System.out.println("Fin du programme") ;
    }
    public static <E> void affiche (Set <E> ens) // programmation générique
    {   Iterator <E> iter = ens.iterator () ;
        while (iter.hasNext())
        {   System.out.print (iter.next() + " ") ;
        }
        System.out.println() ;
    }
}
