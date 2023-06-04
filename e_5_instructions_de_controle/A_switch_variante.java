// la variante du switch case comme en c++ fonctionne idem
// ci-dessous une variante simplifiée avec :
//      - possibilité de brancher plusieurs case à une seule ligne
//      - pas besoin d'écrire de break car auto (un par ligne)
public class A_switch_variante {
    public static void main(String[] args) {
        int nb ;
        boolean encore = true ;
        while (encore)
        {   System.out.print("Fournissez un nombre entier plus différent de 0 (tapez 0 pour arrêter) : ") ;
            nb = Clavier.lireInt() ;
            switch (nb)
            {   case 0 -> {System.out.println("Vous avez choisi d'arrêter la boucle.") ; encore = false ; }
                case 1, 2, 3 -> System.out.println("Vous avez choisi 1, 2 ou 3.") ;
                default -> System.out.println("Vous avez choisi un nombre <0 ou >3.") ;
            }
        }
        System.out.println("Fin du programme") ;
    }    
}
