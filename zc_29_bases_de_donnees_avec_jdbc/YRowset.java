import java.sql.* ;
import javax.sql.rowset.* ;   // pour JdbcRowSet

public class YRowset
{   public static void main (String[] args) throws ClassNotFoundException, SQLException
    {   String url = "jdbc:derby:/Users/alejandramt/Developpement/java/zc_29_bases_de_donnees_avec_jdbc/stocks" ;
        String commande = "SELECT REF, NAME FROM FOURNISSEURS" ; // modif par moi
        //JdbcRowSet est en permanence connecté à la base de données
        JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet() ; // modifié par moi
        rs.setUrl(url) ;
        rs.setType(ResultSet.TYPE_SCROLL_SENSITIVE) ;
        rs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
        rs.setCommand(commande);
        rs.execute();
        
        String ref, name ;
        // petite mise à jour
        rs.first() ; // aller à la première ligne du résultat de la requête
        rs.updateString(2, "Big Boss") ;
        rs.updateRow();
        // liste dans l'ordre inverse
        rs.afterLast();
        while (rs.previous())
        {   ref  = rs.getString (1) ; name  = rs.getString (2) ;
            System.out.println ("Ref : " + ref + " / nom : " + name) ;
        }
        // libération des ressources
        rs.close ();

  }
}
