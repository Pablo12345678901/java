public class B_conversion_int_en_float_et_perte_precision {
    public static void main(String[] args) {
        int nb_int = 2147483647 ;
        int ecart = 0 ;
        float nb_float ;
        for (int i=0; i<100; i++)
        {   nb_float = nb_int ; // conversion
            ecart = nb_int - (int) nb_float ;
            System.out.println("conversion de " + nb_int + " en float " + nb_float + " perte de précision de " + ecart + " unités.") ;
            nb_int -= 1001 ;
        }
    }    
}
