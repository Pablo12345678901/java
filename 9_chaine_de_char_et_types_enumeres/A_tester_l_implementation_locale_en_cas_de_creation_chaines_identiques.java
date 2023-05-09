public class A_tester_l_implementation_locale_en_cas_de_creation_chaines_identiques {
    public static void main(String[] args) {

        System.out.println("Rappel : les résultats peuvent varier selon l'implémentation.\n") ;

        System.out.println("Test de création de 2 chaînes de même valeur \"bonjour\".") ;
        String ch1 = "bonjour" ;
        String ch2 = "bonjour" ;
        if (ch1 == ch2) System.out.println("Égales") ;
        else System.out.println("Différentes") ;
        System.out.println() ;

        System.out.println("Test de création d'une chaîne \"bonjour\" et une autre \"bon\" à laquelle j'ajoute \"+=jour\".") ;
        String ch3 = "bonjour" ;
        String ch4 = "bon" ;
        ch4+= "jour" ;
        if (ch3 == ch4) System.out.println("Égales") ;
        else System.out.println("Différentes") ;
        System.out.println() ;
        
        System.out.println("Test de création d'une chaîne \"bonjour1\" et une autre \"bonjour\" à laquelle j'ajoute \"+=1\".") ;
        String ch5 = "bonjour1", ch6 ;
        int n = 1 ;
        ch6 = "bonjour" + n ;
        if (ch5 == ch6) System.out.println("Égales") ;
        else System.out.println("Différentes") ;
        System.out.println() ;
    }

}