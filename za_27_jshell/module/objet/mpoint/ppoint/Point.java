package ppoint ;

public class Point {
    public Point(int x, int y) {this.x = x ; this.y = y ;}
    public Point() {this.x = 0; this.y = 0;}
    public void affiche() { System.out.println("x y : " + x + " " + y);}
    private int x, y ;
}
