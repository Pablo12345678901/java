import java.time.* ;
import java.lang.* ;

public class C_zoneddatetime
{   public static void main (String [] args)
    {       ZonedDateTime maintenant = ZonedDateTime.now();  // par defaut dans local
            ZoneId fuseau_hor_par_defaut = maintenant.getZone() ;
            System.out.println("Fuseau horaire par défaut : " + fuseau_hor_par_defaut) ;
            System.out.println ("Maintenant     : " + maintenant) ;
            String jourSem = conversion_date_en_jour_sem_str(maintenant) ;
            System.out.println ("Nous sommes un "+ jourSem) ;

            ZoneId idChicago = ZoneId.of("America/Chicago") ;
            ZonedDateTime aChicago = maintenant.withZoneSameInstant(idChicago) ;
            System.out.println ("Maintenant a Chicago      : " + aChicago) ;
            String jourSem_2 = conversion_date_en_jour_sem_str(aChicago) ;
            System.out.println ("C'est un "+ jourSem_2) ;
            
            if (maintenant.isEqual(aChicago)) System.out.println ("Dates/heures identiques") ; // vérifie si c'est égal au même instant au 2 endroits
            
            ZoneOffset offsetChicago = aChicago.getOffset() ;
            System.out.println ("Offset de Chicago : " + offsetChicago.getTotalSeconds()) ; // en secondes uniquement
            
            // franchissement du changement d'heure hiver -> ete
            LocalDateTime dateHeureLocale = LocalDateTime.of(2014, 3, 25, 16, 30) ;
            ZonedDateTime dateHeure = ZonedDateTime.of(dateHeureLocale,ZoneId.of("Europe/Paris")) ;
            
            System.out.println ("Date_Heure initiale       : " + dateHeure) ;
            // Ajout de 30 jours - temps humain
            ZonedDateTime dateHeure30 = dateHeure.plusDays(30) ;
            System.out.println ("Date_Heure + 30 jours     : " + dateHeure30) ;
            // Ajout de 30 * 24 h - temps machine
            ZonedDateTime dateHeure30x24 = dateHeure.plusHours(30*24) ;
            System.out.println ("Date_Heure + 30*24 heures : " + dateHeure30x24) ;

            // Ajout de 30 jours - temps humain (période)
            Period trenteJours = Period.ofDays(30) ;
            ZonedDateTime dateHeurePeriode = dateHeure.plus(trenteJours) ;
            System.out.println ("Date_Heure + periode 30 j : " + dateHeurePeriode) ;
            // Ajout de 30 * 24 h - temps machine (duration)
            Duration duree = Duration.ofDays(30) ;
            ZonedDateTime dateHeureDuree = dateHeure.plus(duree) ;
            System.out.println ("Date_Heure + duree 30 j   : " + dateHeureDuree) ;
    }
    public static String conversion_date_en_jour_sem_str(ZonedDateTime date)
    {   String jour_semaine = date.getDayOfWeek().toString().toLowerCase() ;
        return jour_semaine ;
    }
}


