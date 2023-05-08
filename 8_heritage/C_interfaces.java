public class C_interfaces {
    public static void main(String[] args) {
        I1 [] tableau = new I1 [2] ;
        tableau[0] = new C1() ;
        tableau[1] = new C2() ;
        for (int i=0; i<2 ; i++) tableau[i].affiche() ;
        ((I2)tableau[1]).parle() ; // conversion de la référence en I1 -> I2 pour utiliser la méthode I2.parle
    }
}

interface I1 {
    static final int MAX = 100 ;
    void affiche() ;
}
interface I2 extends I1 {
    static final int MIN = 0 ;
    void parle() ;
}

class C1 implements I1 {
    public void affiche()
    { System.out.println("C1 - Le maximum vaut : " + MAX) ;}
}

class C2 implements I2 {
    public void affiche()
    { System.out.println("C2 - Le maximum vaut : " + MAX + " et le minimum vaut : " + MIN) ;}
    public void parle()
    { System.out.println("C2 - Blablabla je parle pour rien dire...") ;}
}