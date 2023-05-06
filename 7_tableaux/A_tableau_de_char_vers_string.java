//import java.util.Arrays ; // nécessaire si j'utilise Arrays.toString(tableauDeChar)

public class A_tableau_de_char_vers_string {
    public static void main(String[] args) {
        char [] mot = {'s','a','l','u','t'} ;
        //String mot_str = Arrays.toString(mot) ;
        String mot_str = String.valueOf(mot) ;
        System.out.println(mot_str ) ;
    }
}
