import java.sql.* ;
// obtenir des données sur la base de données (et son driver)
public class DBMetadonnees    
{   public static void main (String[] args) throws ClassNotFoundException, SQLException
    {   String url = "jdbc:derby:/Users/alejandramt/Developpement/java/zc_29_bases_de_donnees_avec_jdbc/stocks" ;
        Connection connec = DriverManager.getConnection(url);
        DatabaseMetaData metad = connec.getMetaData() ;
        System.out.println ("---- Défilement et actualisation :") ;
        if (metad.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY))
            System.out.println ("TYPE_FORWARD_ONLY") ;    
        if (metad.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE))
                System.out.println ("TYPE_SCROLL_INSENSITIVE") ; ;
        if (metad.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE))
                System.out.println ("TYPE_SCROLL_SENSITIVE") ;
        String pilote = metad.getDriverName() ;
        String versionPilote = metad.getDriverVersion() ;  
        System.out.println ("--- Nom du pilote = " + pilote + " version " + versionPilote) ;
        String sgdbr = metad.getDatabaseProductName() ;
        String versionSgdbr = metad.getDatabaseProductVersion() ;
        System.out.println ("--- Nom du SGDBR = " + sgdbr + " version " + versionSgdbr) ;
        String motsSQL = metad.getSQLKeywords() ;
        System.out.println ("--- Mots cles SQL = " + motsSQL) ;
        ResultSet typesSQL = metad.getTypeInfo() ;
        System.out.println ("--- Types SQL") ;
        while (typesSQL.next())
        { String type = typesSQL.getString(1) ;   // ou getString ("TYPE_NAME") 
            System.out.print (type + ", " ) ; 
        }
        System.out.println () ;
    }
}

