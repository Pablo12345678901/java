import java.time.Instant;
import java.time.Duration ;

public class B_gestion_des_duree
{   public static void main (String [] args)
    {   final int DUREE_BOUCLE_MS = 3000 ;  // ou long
        // .....
        Instant maintenant = Instant.now() ;
        Instant debut = maintenant ;
        System.out.println ("Debute a : " + maintenant) ;
        Instant fin = maintenant.plusMillis(DUREE_BOUCLE_MS) ;
        do { // traitement
            maintenant = Instant.now() ;
            System.out.println("" + maintenant) ;
        }
        while (fin.isAfter(maintenant)) ;
        System.out.println ("Début à :  " + debut) ;
        System.out.println ("Fini a :   " + maintenant) ;
        
        // Calcul du décallage entre la durée théorique et réelle
        Duration duree_theorique = Duration.between(debut, fin) ;
        Duration duree_reelle = Duration.between(debut, maintenant) ;
        Duration ecart = duree_reelle.minus(duree_theorique) ;
        Long ecart_sec = ecart.toSeconds() ;
        Long ecart_nanos = ecart.toNanos() ;
        System.out.println("Décallage en seconde(s) par rapport à durée souhaitée : " + ecart_sec + " sec + " + ecart_nanos + " ns (1s/1mia)") ;
        double sec = (double) ecart_sec + ((double) ecart_nanos)/(1e9) ;
        System.out.println("Soit : " + sec + " s") ;
    }
}
