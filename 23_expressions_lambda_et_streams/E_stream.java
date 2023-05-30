import java.util.stream.*;
import java.util.* ;

public class E_stream
{   public static void main (String [] args)
    {   Integer [] tab = { 2, 15, -3, 2, -5, 34, 23, 4, -8, 12 } ;
        System.out.println ("--- Carres des negatifs, double des positifs") ;
        Stream.of(tab).map( e -> { if (e>=0) return 2*e ; //  ici, on peut aussi
                                else return e*e; }    //  utiliser mapToInt
                                )                       
                    .forEach (e -> System.out.print (e + " ")) ; // Puis affichage des résultats
        
        System.out.println ("\n--- Valeurs et nombre de negatifs") ;
        long nb_neg = Stream.of(tab).filter(e -> e<0) // obtention nb strictement négatif
                                    .peek(e -> System.out.print(e + " ")) // affichage : peek applique une action et retourne un Stream
                                    .count() ;    // comptage
        System.out.println (" ** Nombre de negatifs : "+ nb_neg) ;
        
        System.out.println ("--- Valeurs triees ordre naturel :") ;
        Stream.of(tab).sorted().forEach (e -> System.out.print (e + " ")) ;
        
        System.out.println("\n--- Valeurs triees ordre naturel en parallele, avec forEachOrdered :") ;
        Stream.of(tab).parallel().sorted().forEachOrdered (e -> System.out.print (e + " ")) ; // Notez ici : forEachOrdered
        
        System.out.println ("\n--- Valeurs triees ordre inverse, sans doublons :") ;
        Stream.of(tab).sorted(Comparator.reverseOrder()) // impossible si int[] tab car s'applique sur des objets uniquements
                    .distinct() 
                    .forEach (e -> System.out.print (e + " ")) ;

    // Similaire avec IntStream
    System.out.println("") ;
    System.out.println("") ;
    System.out.println("") ;
    int [] tab_int = { 2, 15, -3, 2, -5, 34, 23, 4, -8, 12 } ;
    System.out.println ("--- Carres des negatifs, double des positifs") ;
    IntStream.of(tab_int).map( e -> { if (e>=0) return 2*e ; //  ici, on peut aussi
                            else return e*e; }    //  utiliser mapToInt
                            )                       
                .forEach (e -> System.out.print (e + " ")) ; // Puis affichage des résultats
    
    System.out.println ("\n--- Valeurs et nombre de negatifs") ;
    long nb_neg_2 = IntStream.of(tab_int).filter(e -> e<0) // obtention nb strictement négatif
                                .peek(e -> System.out.print(e + " ")) // affichage : peek applique une action et retourne un Stream
                                .count() ;    // comptage
    System.out.println (" ** Nombre de negatifs : "+ nb_neg_2) ;
    
    System.out.println ("--- Valeurs triees ordre naturel :") ;
    IntStream.of(tab_int).sorted().forEach (e -> System.out.print (e + " ")) ;
    
    System.out.println("\n--- Valeurs triees ordre naturel en parallele, avec forEachOrdered :") ;
    IntStream.of(tab_int).parallel().sorted().forEachOrdered (e -> System.out.print (e + " ")) ; // Notez ici : forEachOrdered
    
    System.out.println ("\n--- Valeurs triees ordre inverse, sans doublons :") ;
    IntStream.of(tab_int) // inverser l'ordre -> il n'existe pas de fonction pour reversedOrder sur un IntStream
    // Donc "bricolage" ci-dessous : 
                .map(i -> -i) // inverser les valeurs > les plus grands deviennent les plus petits
                .sorted().map(i -> -i) // trier l'ordre du plus petit au plus grand
                .distinct() // réinverser les valeurs pour obtenir l'ordre inverse
                .forEach (e -> System.out.print (e + " ")) ;
    }
}