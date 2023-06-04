import java.lang.annotation.* ;
import java.lang.reflect.* ;

public class C_annotations_base
{  public static void main (String args[]) throws NoSuchMethodException // NoSuchMethodException : déclenchée par "getDeclaredMethod" si méthode inexistante dans la class
   {    if (A.class.isAnnotationPresent (Infos.class)) System.out.println ("-- @Infos présente sur A") ;
        else System.out.println ("-- @Infos non présente sur A") ;

        if (B.class.isAnnotationPresent (Infos.class)) System.out.println ("-- @Infos présente sur B") ;
        else System.out.println ("-- @Infos non présente sur B") ;
        
        Method m1 = A.class.getDeclaredMethod("f") ;
        if (m1.isAnnotationPresent(Infos.class))    
        {   System.out.println ("-- @Infos présente sur A.f") ;
            Infos ainf1 = m1.getAnnotation(Infos.class) ;
            System.out.println ("message = " + ainf1.message()) ;
            System.out.println ("value   = " + ainf1.value()) ;
        }  
        
        Method m2 = A.class.getDeclaredMethod("g") ;
        if (m2.isAnnotationPresent(Infos.class))    
        {   System.out.println ("-- @Infos présente sur A.g") ;
            Infos ainf2 = m2.getAnnotation(Infos.class) ;
            System.out.println ("message = " + ainf2.message()) ;
            System.out.println ("value   = " + ainf2.value()) ;
        }  
        // Test avec une méthode qui n'existe pas
        try
        {   Method m3 = A.class.getDeclaredMethod("w") ;
            if (m3.isAnnotationPresent(Infos.class))    
            {   System.out.println ("-- @Infos présente sur A.g") ;
                Infos ainf3 = m3.getAnnotation(Infos.class) ;
                System.out.println ("message = " + ainf3.message()) ;
                System.out.println ("value   = " + ainf3.value()) ;
            }  
        } 
        catch (NoSuchMethodException e) {
            System.out.println("-- Méthode \"w\" inexistante dans la class A.") ;
        }
        // Test avec une méthode sans annotation
        Method m4 = A.class.getDeclaredMethod("h") ;
        if (m4.isAnnotationPresent(Infos.class))    
        {   System.out.println ("-- @Infos présente sur A.h") ;
            Infos ainf4 = m4.getAnnotation(Infos.class) ;
            System.out.println ("message = " + ainf4.message()) ;
            System.out.println ("value   = " + ainf4.value()) ;
        }
        else System.out.println("-- Annotation @Infos non présente dans méthode \"h\" de la class A.") ;
   }
}
@Infos(message = "Message Classe A", value = 20)
class A 
{   @Infos (message = "Message methode f")
    void f() {}
    @Infos (12)
    void g() {}
    void h() {}
}
class B {}

@Retention (RetentionPolicy.RUNTIME)
@interface Infos
{   String message() default "Rien" ;
    int value () default 0 ;
}
