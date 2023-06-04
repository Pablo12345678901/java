public class E_char_unicode {
    public static void main(String[] args) {
        final char CARDEB = 32, CARFIN = 1000 ;
        char c ;
        for (c=CARDEB; c<CARFIN; c++)
        {   System.out.println((int)c + " : " + c) ;
        }
        System.out.println("Fin du programme") ;
    }
}
