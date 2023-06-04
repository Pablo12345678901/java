open module z_26_modules_et_packages.module_d { // permet l'introspection de tous les packages du Module_D durant l'exécution
    requires z_26_modules_et_packages.module_b ;
    //requires static z_26_modules_et_packages.module_b ; // static signifie que la réquisition se fera optionnellement selon si Module_B est réellement utilisé
}
