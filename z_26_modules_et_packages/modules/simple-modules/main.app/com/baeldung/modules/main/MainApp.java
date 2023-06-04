package com.baeldung.modules.main;

//import com.baeldung.modules.hello.HelloModules;
import java.util.*; // pour la class ServiceLoader
import com.baeldung.modules.hello.*; // pour l'import de HelloModules et de HelloInterface

public class MainApp {
    public static void main(String[] args) {
        HelloModules.doSomething();
        // we use the service from the class "HelloModules" which implements "HelloInterface" via a ServiceLoader:
        Iterable<HelloInterface> services = ServiceLoader.load(HelloInterface.class);
        HelloInterface service = services.iterator().next();
        service.sayHello();
    }
}