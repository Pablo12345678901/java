package z_26_modules_et_packages.packages.packages_test ;

public class B_class {
    public void affiche() { System.out.println(bonjour + " " + bonsoir) ;}
    public void affiche(A_class a) { System.out.println(bonjour + a.x + " " + bonsoir + a.y) ;}
    public String bonjour = "Bonjour " ;
    public String bonsoir = "Bonsoir " ;
    public static void main(String[] args) {
        System.out.println("Main function class A") ;
        B_class objetB = new B_class() ;
        A_class objetA = new A_class() ;
        objetB.affiche(objetA);
    }
}
