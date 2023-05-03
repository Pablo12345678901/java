public class A_boolean {
    public static void main(String[] args) {
        boolean ok = true ;
        for (int i=0; i<5; i++)
        {   ok = !ok ;
            System.out.println("Le booléen vaut : " + ok) ;
        }
        System.out.println("Fin du programme") ;
    }
}