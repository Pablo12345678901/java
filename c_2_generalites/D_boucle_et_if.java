public class D_boucle_et_if {
    public static void main(String[] args) {
        int i ;
        final int NBFOIS = 5 ; // final = const
        double nb = 0;
        double rac_nb = 0 ;
        System.out.println("Je vais vous calculer " + NBFOIS + " racines.");
        for (i=0 ; i<NBFOIS; i++)
        {   System.out.print( (i+1) + ". Fournissez un nombre : ") ;
            nb = Clavier.lireDouble() ;
            if (nb<0) System.out.println("Ce nombre : " + nb + " est négatif et n'a pas de racine.") ;
            else
            {   rac_nb = Math.sqrt(nb) ;
                System.out.println("La racine de " + nb + " = " + rac_nb) ;
            }
        }
        System.out.println("Fin du programme   \u30D0"); // Affichage d'un caractère spécial à l'aide de la conversion d'un char Unicode en hexadecimal
    }
}
