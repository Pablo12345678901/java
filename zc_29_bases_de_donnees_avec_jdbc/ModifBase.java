//package zc_29_bases_de_donnees_avec_jdbc ;

import java.sql.* ;    // pour SQLException, DriverManager, Statement, ResultSet

public class ModifBase         
{   public static void main (String[] args) throws ClassNotFoundException, SQLException 
    {   // recherche et enregistrement du pilote et etablissement connexion
           
        //Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ; // inutile - était là avant
        
        //Connection connec = DriverManager.getConnection("jdbc:derby://localhost:1527//Users/alejandramt/Developpement/java/zc_29_bases_de_donnees_avec_jdbc/stocks");  // pour travailler en serveur en même temps que je visualise la DB via DBEAVER
        Connection connec = DriverManager.getConnection("jdbc:derby:/Users/alejandramt/Developpement/java/zc_29_bases_de_donnees_avec_jdbc/stocks");  // pour travailler en embedded - un seul accès à la fois - je ne peux pas visualiser les data en même temps que je travaille dessus
        //Connection connec = DriverManager.getConnection("jdbc:derby:stocks") ;
        //Connection connec = DriverManager.getConnection("jdbc:derby:stocks");  // pour travailler en embedded - un seul accès à la fois - je ne peux pas visualiser les data en même temps que je travaille dessus
        
        // cr�ation de l'objet de type Statement associ� � la connexion, avec
        // parcours bidirectinnel et r�sultats actualisables 
        String requete = "SELECT * FROM FOURNISSEURS" ;
        Statement stmt = connec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE) ; // scroll : bidirectionnel + DB adaptable au fur et à mesure de la consultation
        // ex�cution de la requ�te SQL de s�lection de donn�es
        ResultSet res ;
        res = stmt.executeQuery(requete);
        // actualisation de la base, via les r�sultats :
        // on ajoute 10 unit�s au produit de r�f�rence A521
        String refCherchee = "B1" ;  // r�f�rence dont on veut modifier la quantit�
        while (res.next())
        {   String ref = res.getString(1) ;
            if (ref.equals(refCherchee))    {  String ancienNom = res.getString(2) ;
                                                res.updateString (2, "Nouveaunom") ;
                                                res.updateRow () ;
                                            }
        }   
        // liste de la table modifi�e, dans l'ordre inverse
        System.out.println ("--- La table fournisseur apr�s modification") ;
        res.afterLast () ; // placement du curseur après la fin de la table (parcours en sens inverse)
        while (res.previous())
        {   String reference = res.getString ("ref") ;
            String nom = res.getString ("name") ;
            System.out.println ("Réf : " + reference + " / nom : " + nom) ;
        }
        // lib�ration des ressources
        stmt.close() ;
        res.close();
        connec.close();
        /* //DEBUG
        String [] keys  = new String [] { "java.class.path",  "jdk.module.path", "jdk.module.upgrade.path", "jdk.module.main", "jdk.module.main.class " } ;
        for (String key : keys) System.out.println("\n" + System.getProperty(key)) ;
        */
    }  
}

