module Module_B {
    requires transitive Module_C ; // tout les modules qui requierent B requierent C (transitive)
    exports NomClass_1 ; // accessible à tous les modules qui le souhaite
    exports NomClass_2 to Module_A, Module_D ; // accessible qu'au Module_A et D
}
