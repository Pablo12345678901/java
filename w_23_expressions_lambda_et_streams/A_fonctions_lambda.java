//package 23_expressions_lambda_et_streams ;
import java.util.concurrent.ThreadLocalRandom;

interface Calculateur { public int calcul (int n) ; }
interface Calculateur_2 { public int calcul_2 (int n) ; }

public class A_fonctions_lambda
{   public static void main (String [] args)
    {   for (int i=0 ; i<tabCalc_2.length ; i++)
        {   int randIndex = ThreadLocalRandom.current().nextInt(0, tabCalc.length);
            int randomNum = ThreadLocalRandom.current().nextInt(0, 100+1);
            traite_calc_2 (randomNum, tabCalc_2[randIndex]) ;
            for (int z=0 ; z<tabCalc.length ; z++) traite (randomNum, tabCalc[z]) ;
            System.out.println("") ;
        }
    }
    public static void traite (int n, Calculateur cal)
    {   int res = cal.calcul(n) ;
        System.out.println ("calcul(" + n + ") = " + res) ;
    }
    public static void traite_calc_2 (int n, Calculateur_2 calc_2)
    {   int res = calc_2.calcul_2(n) ;
        System.out.println ("calcul(" + n + ") = " + res) ;
    }    
    private static Calculateur [] tabCalc = { x -> x*x, x -> 2*x, x -> (int)Math.sqrt (x) } ;
    private static Calculateur_2 [] tabCalc_2 = { x -> tabCalc[0].calcul(x), x -> tabCalc[1].calcul(x), x -> tabCalc[2].calcul(x)} ;
}