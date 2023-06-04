module z_26_modules_et_packages.module_b {
    requires transitive z_26_modules_et_packages.module_c ; // tout les modules qui requierent B requierent C (transitive)
    //exports NomClass_1 ; // accessible à tous les modules qui le souhaite
    //exports NomClass_2 to z_26_modules_et_packages.module_a, z_26_modules_et_packages.module_d ; // accessible qu'au Module_A et D
}
