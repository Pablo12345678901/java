package ZZZ_Ressources_livres.chap24;
import java.lang.annotation.* ;
import java.lang.reflect.* ;
public class IntroAnnot
{ public static void main (String args[]) throws NoSuchMethodException
   { if (A.class.isAnnotationPresent (Infos.class)) 
           System.out.println ("-- @Infos pr�sente sur A") ;
      else System.out.println ("-- @Infos non pr�sente sur A") ;
     if (B.class.isAnnotationPresent (Infos.class)) 
           System.out.println ("-- @Infos pr�sente sur B") ;
      else System.out.println ("-- @Infos non pr�sente sur B") ;
     
     Method m1 = A.class.getDeclaredMethod("f") ;
     if (m1.isAnnotationPresent(Infos.class))    
      { System.out.println ("-- @Infos pr�sente sur A.f") ;
        Infos ainf1 = m1.getAnnotation(Infos.class) ;
        System.out.println ("message = " + ainf1.message()) ;
        System.out.println ("value   = " + ainf1.value()) ;
      }  
     
     Method m2 = A.class.getDeclaredMethod("g") ;
     if (m2.isAnnotationPresent(Infos.class))    
      { System.out.println ("-- @Infos pr�sente sur A.g") ;
        Infos ainf2 = m2.getAnnotation(Infos.class) ;
        System.out.println ("message = " + ainf2.message()) ;
        System.out.println ("value   = " + ainf2.value()) ;
      }  
   }
}
@Infos(message = "Message Classe A", value = 20)
class A 
{ @Infos (message = "Message methode f")
  void f() {}
  @Infos (12)
  void g() {}
  void h() {}
}
class B {}
 @Retention (RetentionPolicy.RUNTIME)
 @interface Infos
 { String message() default "Rien" ;
   int value () default 0 ;
 }