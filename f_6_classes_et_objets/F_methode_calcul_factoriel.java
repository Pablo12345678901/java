public class F_methode_calcul_factoriel {
    public static long fact(long nb) // factoriel
    {   if (nb == 1) return 1 ;
        else return nb * fact(nb-1) ;
    }
    public static void main(String[] args) {
        int nb = -1 ;
        while (nb!=0)
        {   System.out.print("Calcul de la factorielle du nombre : (tapez 0 pour arrêter) ") ;
            nb = Clavier.lireInt() ;
            if (nb==0) break ;
            else System.out.println("Factorielle de : " +  nb + " = " + fact(nb)) ;
        }
        System.out.println("Fin du programme.") ;
    }
}