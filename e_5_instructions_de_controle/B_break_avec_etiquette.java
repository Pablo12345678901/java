public class B_break_avec_etiquette {
    public static void main(String[] args) {
        int nb ;
        boolean encore = true ;
        System.out.println("Avant la boucle") ;
        debut :
        {   while (encore)
            {   System.out.print("Fournissez un nombre entier plus différent de 0 (tapez 0 pour arrêter) : ") ;
                nb = Clavier.lireInt() ;
                switch (nb)
                {   case 0 -> {System.out.println("Vous avez choisi d'arrêter la boucle.") ; encore = false ; }
                    case 1, 2, 3 -> System.out.println("Vous avez choisi 1, 2 ou 3.") ;
                    default -> System.out.println("Vous avez choisi un nombre <0 ou >3.") ;
                }
                if (nb==4) break debut ; // envoie le programme jusqu'à bloc (en bas avant la
                //boucle - similaire au goto du C++ (mais le mot cité doit
                //englober le bloc du code dans lequel il est appelé
                // et il renverra après ce bloc
            }
            System.out.println("Fin première boucle") ;
        } // le "break debut" renverra ici
        System.out.println("Fin du programme") ;
    }    
}
