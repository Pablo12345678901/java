import java.lang.annotation.* ;
import java.lang.reflect.* ;

public class D_annotations_avance
{   public static void main (String args[]) throws NoSuchMethodException
    {   // annotations de class
        Annotation[] annotationsDeA = A.class.getAnnotations() ;
        System.out.println ("Annotations de la classe A : ");
        for (Annotation a : annotationsDeA) System.out.println (a.annotationType().getName()) ;
        
        // annotations de méthode
        Method m1 = A.class.getDeclaredMethod("f") ;
        Annotation[] annotationsDEf = m1.getAnnotations() ;
        System.out.println ("Annotations de la methode A.f : ");
        for (Annotation a : annotationsDEf) System.out.println (a.annotationType().getName()) ;
        
        // annotations de class y.c héritées
        Annotation[] annotationsDeB = B.class.getAnnotations() ;
        System.out.println ("Annotations de la classe B : ");
        for (Annotation a : annotationsDeB) System.out.println (a.annotationType().getName()) ;
        
        // annotations de class sans héritées
        Annotation[] annotationsDeclDeB = B.class.getDeclaredAnnotations() ;
        System.out.println ("Annotations declarees de la classe B : ");
        for (Annotation a : annotationsDeclDeB) System.out.println (a.annotationType().getName()) ;         
    }
}

@Deprecated
@Infos(message = "Message Classe A", value = 20)
class A 
{   @Deprecated
    @Infos (message = "Message methode f")
    void f() {}
 }

class B extends A
{   @Override // override s'applique à la méthode f, pas à la class B
    void f() {}	
}

@Retention (RetentionPolicy.RUNTIME)
@Inherited
@interface Infos
{   String message() default "Rien" ;
    int value () default 0 ;
}

