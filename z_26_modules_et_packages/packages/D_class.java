package z_26_modules_et_packages.packages;
import z_26_modules_et_packages.packages.packages_test.*;

public class D_class {
    public static void main(String[] args) {
        A_class objet_A = new A_class(23, 52) ;
        objet_A.affiche();
        B_class objetB = new B_class() ;
        objetB.affiche(objet_A);
    }
}
