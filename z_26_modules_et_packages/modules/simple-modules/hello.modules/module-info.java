module hello.modules {
    exports com.baeldung.modules.hello ; // partage ce package à qui veut bien l'appeler
    provides com.baeldung.modules.hello.HelloInterface with com.baeldung.modules.hello.HelloModules ; // we declare the interface and which class implements it. > fournit cet interface
}
