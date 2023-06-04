import java.lang.reflect.*;
import java.time.*;
import java.util.stream.*;
import java.util.*;

public class A_introspection_class_Instant
{   public static void main (String args[]) 
    {   // Instructions : modifier uniquement le type de la class (ligne ci-dessous) et le reste s'adapte.
        //Class objetClass = Class.class ; // utiliser cette ligne pour la class Class (spéciale)
        //String objetClass = new String() ; // modifier ici pour des class quelconques
        Instant objetClass = Instant.now() ;
        Class<?> c = objetClass.getClass() ;
        
        separateur() ;
        System.out.println("Liste des champs de la class : " + c.getName() + "\n") ;
        Field [] champs = c.getDeclaredFields() ;
        Comparator<Field> comparator_fi = new Comparator<Field>(){
            public int compare(Field f1, Field f2)
            {   return f1.getName().compareTo(f2.getName());
            }};
        // Ordonancement de la liste des Fields par ordre alphabétique
        Object [] champs_tries_ob = Stream.of(champs)
                                            .sorted(comparator_fi)
                                            .toArray() ;
        Field [] champs_tries_fi = new Field [champs_tries_ob.length] ;
        for (int i=0; i<champs_tries_ob.length; i++)
        {   champs_tries_fi[i] = (Field) champs_tries_ob[i] ;
        }
        // affichage par ordre alphabétique
        int numChamp = 1 ;
        for (Field champ : champs_tries_fi)
        {   // Accès info du champs
            /* 
            String modifier = "" ;
            int mod = champ.getModifiers() ;
            if (Modifier.isPublic(mod)) modifier = "public " ;
            else if (Modifier.isProtected(mod)) modifier = "protected " ;
            else if (Modifier.isPrivate(mod)) modifier = "private " ;
            else if (Modifier.isNative(mod)) modifier = "native " ;
            System.out.println(modifier + champ.getType().getName() + " " + champ.getName() + " " ) ;
            */
            // Affichage info générales du champs
            System.out.println("" + numChamp++ + " " +  champ.getName() + "\n" + champ) ;
            System.out.println() ;
        } 

        separateur() ;
        System.out.println("Liste des méthodes de la class : " + c.getName() + "\n") ;
        Method [] methodes = c.getDeclaredMethods() ;
        Comparator<Method> comparator_me = new Comparator<Method>(){
            public int compare(Method m1, Method m2)
            {   return m1.getName().compareTo(m2.getName());
            }};
        // Ordonancement de la liste des méthodes par ordre alphabétique
        Object [] methodes_tries_ob = Stream.of(methodes)
        .sorted(comparator_me)
        .toArray() ;
        Method [] methodes_tries_fi = new Method [methodes_tries_ob.length] ;
        for (int i=0; i<methodes_tries_ob.length; i++)
        {   methodes_tries_fi[i] = (Method) methodes_tries_ob[i] ;
        }
        // affichage par ordre alphabétique
        int numMethode = 1 ;
        for (Method methode : methodes_tries_fi)
        {   System.out.println("" + numMethode++ + " " +  methode.getName() + "\n" + methode) ;    
            Class<?> typeArgs [] = methode.getParameterTypes() ;
            System.out.print ("- type arguments : ") ;
            if (typeArgs.length>0)
            {   if (typeArgs.length==1) System.out.println(typeArgs[0].getName()) ;
                else
                {   for (int i=0; i<(typeArgs.length-1); i++) System.out.print (typeArgs[i].getName() + ", ") ;
                    System.out.println(typeArgs[typeArgs.length-1].getName()) ;
                }
            }   
            else System.out.println("void") ;
            Class<?> typeRetour = methode.getReturnType() ;
            System.out.println("- type valeur de retour : " + typeRetour.getName()) ;
            System.out.println() ;
        }

        separateur() ;
        System.out.println("Liste des constructeurs de la class : " + c.getName() + "\n") ;
        Constructor<?> constructeurs [] = c.getDeclaredConstructors () ;
        int numConstructeur = 1 ;
        for (Constructor<?> constructeur : constructeurs)
        {   System.out.println("" + numConstructeur++ + " " +  constructeur) ;
            
            System.out.print ("- type arguments : ") ;
            Class<?> typeArgs [] = constructeur.getParameterTypes() ;
            if (typeArgs.length>0)
            {   if (typeArgs.length==1) System.out.println(typeArgs[0].getName()) ;
                else
                {   for (int i=0; i<(typeArgs.length-1); i++) System.out.print (typeArgs[i].getName() + ", ") ;
                    System.out.println(typeArgs[typeArgs.length-1].getName()) ;
                }
            }   
            else System.out.println("void") ;
            System.out.println() ;
        }

        System.out.println("Fin du programme") ;
    }

    private static void separateur()
    {   for (int i=0; i<80; i++) System.out.print("=") ;
        System.out.println("") ;
    }
}
