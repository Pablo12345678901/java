public class B_tableau_vers_chaine {
    public static void main(String[] args) {
        char [] mot = {'b', 'o', 'n', 'j', 'o', 'u', 'r'} ;
        String chaine_mot = new String (mot, 2, 4) ;
        System.out.println("Le tableau initial est : \"" + String.valueOf(mot) + "\" tandis que la nvle chaîne est : \"" + chaine_mot + "\"") ;
        System.out.println("Conversion depuis String vers tableau et affichage ") ;
        char [] nvo_mot = chaine_mot.toCharArray() ;
        for (char c : nvo_mot) System.out.println(c) ;
    }
}
