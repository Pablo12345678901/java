package Z_Repertoire_test_pour_import ;

public class Obj {
    public Obj()
    { System.out.print ("++ creation objet Obj ; ") ;
        nb ++ ;
        System.out.println ("il y en a maintenant " + nb) ;
    }
    public static long nbObj ()
    { return nb ;
    }
  private static long nb=0 ;
}
