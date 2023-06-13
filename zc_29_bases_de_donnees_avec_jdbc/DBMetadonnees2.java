
import java.sql.* ;
public class DBMetadonnees2    
{   public static void main (String[] args) throws ClassNotFoundException, SQLException
    {   String url = "jdbc:derby:/Users/alejandramt/Developpement/java/zc_29_bases_de_donnees_avec_jdbc/firstdb" ;
        Connection connec = DriverManager.getConnection(url);
        DatabaseMetaData metad = connec.getMetaData() ;
    
        String[] Infos = { "TABLE" } ;   // pour le quatri�me argument de getTables
        ResultSet tables = metad.getTables(null, null, null, Infos) ;
        while (tables.next())
        {   String nomTable = tables.getString("TABLE_NAME") ;  // ou : getString (3)
            ResultSet champsTable = metad.getColumns(null, null, nomTable, null) ;
            System.out.println ("Noms, numéro type SQL et type SQL des champs de la table " + nomTable) ;
            while (champsTable.next())
            {   String nomCol = champsTable.getString ("COLUMN_NAME") ;   // ou getString (4) 
                String numTypeSQL = champsTable.getString ("DATA_TYPE") ; // ou getString (5) 
                String typeSQL = champsTable.getString ("TYPE_NAME") ;    // ou getString (6)
                System.out.println (nomCol + ", " + numTypeSQL + ", " + typeSQL) ;
            }
        }
    }
}
