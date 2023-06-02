package packages_test;
import packages_test.A_class;

public class B_class {
    public void affiche() { System.out.println(bonjour + " " + bonsoir) ;}
    public void affiche(A_class a) { System.out.println(bonjour + a.x + " " + bonsoir + a.y) ;}
    public String bonjour = "Bonjour " ;
    public String bonsoir = "Bonsoir " ;
}
