open module Module_D { // permet l'introspection de tous les packages du Module_D durant l'exécution
    requires static Module_B ; // static signifie que la réquisition se fera optionnellement selon si Module_B est réellement utilisé
}
