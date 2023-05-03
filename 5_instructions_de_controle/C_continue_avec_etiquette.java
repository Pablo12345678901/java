public class C_continue_avec_etiquette {
    public static void main(String[] args) {
        int nb_b_w = 0 ;
        int nb = -1 ;
        repet : while (nb!=0)
        {   nb_b_w+=1 ;
            System.out.println("Boucle while n°" + nb_b_w) ;
            System.out.println("Fournissez un nombre positif de boucle for à faire (0 pour arrêter): ") ;
            nb = Clavier.lireInt() ;
            if (nb==0)
            {   System.out.println("Vous avez choisi de sortir de la boucle while.") ;
                break ;
            }
            if (nb<0)
            {   System.out.println("ERREUR : le nb " + nb + " est <0.") ;
                continue ;
            }
            else
            {   for (int i=0; i<nb; i++)
                { System.out.println("Boucle for n°"+ (i+1) + " et i vaut : " + i) ;
                    if (i==5)
                    {   System.out.println("Continue jusqu'à repet\n\n\n") ;
                        continue repet ; // renvoi à la prochaine boucle while
                    }
                }
                System.out.println("Fin de la boucle for.") ;
            }
        }
        System.out.println("Fin du programme") ;
    }
}
