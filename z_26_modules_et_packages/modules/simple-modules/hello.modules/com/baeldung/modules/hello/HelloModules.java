package com.baeldung.modules.hello;

public class HelloModules  implements HelloInterface {
    public static void doSomething() {
        System.out.println("Hello, Modules!");
    }

    public void sayHello() { // redéfinition de la fonction sayHello de l'interface HelloInterface
        System.out.println("Hello !") ;
    }
}
