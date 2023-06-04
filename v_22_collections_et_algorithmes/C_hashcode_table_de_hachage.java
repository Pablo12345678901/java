import java.util.* ;

// Le lien pour l'explication de la théorie sur le hashcode de la fonction HashCode ci-dessous
// Remarques, elles fonctionne que pour des coordonnées positives et petites car
// Le nombre de bit utilisé pour le int de la valeur retourné par la fonction
// correspond à la moitié de droite des bits et chaque coordonnées.
// https://stackoverflow.com/questions/9858376/hashcode-for-3d-integer-coordinates-with-high-spatial-coherence

public class C_hashcode_table_de_hachage
{ public static void main (String args[])
  { Point p1 = new Point (1, 3) ;
    Point p2 = new Point (2, 2) ;
    Point p3 = new Point (4, 5), p4 = new Point (1, 8) ;
    Point p[] = {p1, p2, p1, p3, p4, p3} ;
    HashSet<Point> ens = new HashSet<Point> () ;
    // HashSet ens=new HashSet() ;  <-- avant JDK5.0
    for (Point px : p)           // for (int i=0 ; i<p.length ; i++)  <-- avant JDK5.0
    { System.out.print ("le point ") ;
      px.affiche() ;
      System.out.println ("") ;                           // p[i].affiche() ; <-- avant JDK5.0
      boolean ajoute = ens.add (px) ;
    // boolean ajoute = ens.add (p[i]) ; <-- avant JDK5.0
      if (ajoute) System.out.println (" a ete ajoute") ;
             else System.out.println ("est deja present") ;
      System.out.print ("ensemble = " ) ; affiche(ens) ;
    }
    //boolean ajoute = ens.add (p1) ;
  }
  public static void affiche (HashSet<Point> ens)
    //  public static void affiche (HashSet ens) <-- avant JDK5.0
  { Iterator<Point> iter = ens.iterator() ;
    // Iterator iter = ens.iterator() ;  <-- avant JDK5.0
    while (iter.hasNext())
    { Point p = iter.next() ; // Point p = (Point)iter.next() ;  <-- avant JDK5.0
      p.affiche() ;
    }
    System.out.println () ;
  }
}

class Point
{ Point (int x, int y) { this.x = x ; this.y = y ; }
    public int hashCode ()
    {   int compteur = 0 ;
        BitSet bits_array = new BitSet(32) ;
        int value ;
        for (int i=31; i>=0; i--)
        {   if (i%2==0)
            {   value = getBit(x, compteur) ;
                compteur++ ;
            }
            else
            {   value = getBit(y, compteur);
            }
            if (value == 0) bits_array.set(i, false) ;
            else if (value == 1) bits_array.set(i, true) ;
            else
            {   System.out.println("Erreur : bit inconnu") ;
                return -1 ;
            }
        }
        /* Affichage des codes binaires
        for (int i=31; i>=0; i--)
        {   System.out.print("" + getBit(x, i) + " ") ;
        }
        System.out.println("") ;
        for (int i=31; i>=0; i--)
        {   System.out.print("" + getBit(y, i) + " ") ;
        }
        System.out.println("") ;
        for (int i=0; i<32; i++)
        {   if (bits_array.get(i) == false) System.out.print("0 ") ;
            else if (bits_array.get(i) == true) System.out.print("1 ") ;
        }
        System.out.println("") ;
        */

        // Conversion depuis binaire vers int
        /*
        - Pour convertir un nombre binaire en nombre décimal, il faut partir d'un total nul qu'on multiplie par 2 et auquel on ajoute le bit (en partant depuis la gauche).
        - Ceci donnera le nouveau total et ensuite on répète l'opération (* 2 + bit)
        EXEMPLE
        1 1 1 1 1 0 1 0 vers entier (> en partant depuis la gauche) :
        Le total initial est toujours égal à 0.
        Calcul		Total (Rés)	Chiffre actuel			Résultat
        2 * 		0 + 		1 		=		1
        2 * 		1 + 		1		=		3
        2 * 		3 + 		1		=		7
        2 * 		7 + 		1		=		15
        2 * 		15 +		1		=		31
        2 * 		31 +		0		=		62
        2 * 		62 +		1		=		125
        2 * 		125 +		0		=		250
        */
        int resultat_final = 0;
        for (int i=0; i <32; i++)
        
        {   //DEBUG System.out.println("resultat_inter : " + resultat_final) ;
            resultat_final *= 2 ;
            if (bits_array.get(i)==true) resultat_final++ ;
        }
        //DEBUG System.out.println("Resultat final = " + resultat_final) ;
        return resultat_final ; 
    }
    public boolean equals (Object pp)
    { Point p = (Point) pp ;
        // nouveau equals = meilleur
        return (this.hashCode() == p.hashCode()) ;
        //ancien equals du prof = nul car les points [1, 3] et [2, 2] sont equals alors qu'ils ne devraient pas
        // return ((this.x == p.x) & (this.y == p.y)) ;
    }
    public void affiche ()
    { System.out.print ("[" + x + " " + y + "] ") ;
    }
    public int getBit(int n, int k)
    { return (n >> k) & 1;
    }
    private int x, y ;
}
