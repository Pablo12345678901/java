public class A_infini_et_nan {
    public static void main(String[] args) {
        float nb_eleve = 1e30f ;
        float resultat_0 = nb_eleve * nb_eleve ; // division par 0
        System.out.println("Dépassement de capacité = infini") ;
        System.out.println(nb_eleve + " * " + nb_eleve + " = " + resultat_0) ;

        float nb_1 = 10f ;
        float nb_2 = 0.0f ;
        float resultat_1 = nb_1 / nb_2 ; // division par 0
        System.out.println("Division par 0 = infini") ;
        System.out.println(nb_1 + " / " + nb_2 + " = " + resultat_1) ;
        
        float inf_pos = Float.POSITIVE_INFINITY ;
        float inf_neg = Float.NEGATIVE_INFINITY ;
        float resultat_2 = inf_pos / inf_neg ;
        System.out.println("Infini divisé par -infini = Nan") ;
        System.out.println(inf_pos + " / " + inf_neg + " = " + resultat_2) ;
    }    
}
