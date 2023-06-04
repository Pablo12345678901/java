public class C_lecture_au_clavier {
    public static void main(String [] args) // ou String args[]
    {   int nb_int ;
        double nb_dou = 1.3e10 ;
        char carac = 'a' ;
        System.out.print("Veuillez fournir un nombre : ");
        nb_int = Clavier.lireInt() ;
        System.out.println("nb_int = " + nb_int);
        System.out.println("nb_dou = " + nb_dou);
        System.out.println("carac = " + carac);
        // en une ligne
        System.out.println("nb_int = " + nb_int + " nb_dou = " + nb_dou + " carac = " + carac);
}
}
