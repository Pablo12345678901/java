package packages_test ;

public class A_class {
    public A_class() {  this.x = 10; this.y = 20 ; }
    public void affiche() { System.out.println("x y : " + x + y) ; }
    public int x, y ;
    public static void main(String[] args) {
        System.out.println("Main function") ;
    }
}
