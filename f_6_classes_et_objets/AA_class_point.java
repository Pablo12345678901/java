
public class AA_class_point {
    public static void main(String[] args) {
        A_class_point a ; // création d'un référence vers un point
        a = new A_class_point() ; // création d'un point et assignation à la référence
        a.initialise(12, 23);
        a.affiche();
        a.deplace(-3, 32);
        a.affiche() ;
        System.out.println("Fin du programme.") ;
    }

}