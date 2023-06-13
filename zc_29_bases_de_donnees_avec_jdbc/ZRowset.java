import java.sql.* ;
//import com.sun.rowset.CachedRowSetImpl ;   // ou sun.rowset.CachedRowSetImpl
import javax.sql.rowset.* ;   // pour CachedRowSet

public class ZRowset
{ public static void main (String[] args) throws ClassNotFoundException, SQLException
  { //Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ; 
    //CachedRowSet rs = new CachedRowSetImpl () ;
    String url = "jdbc:derby:/Users/alejandramt/Developpement/java/zc_29_bases_de_donnees_avec_jdbc/stocks" ;
    String commande = "SELECT REF, NAME FROM FOURNISSEURS" ; // modif par moi
    // CachedRowSet ne se connecte à la base de données que quand je le lui demande avec "acceptChanges()" (synchronisation des modifications)
    CachedRowSet rs = RowSetProvider.newFactory().createCachedRowSet() ; // modifié par moi
    rs.setUrl (url);
    rs.setType (ResultSet.TYPE_SCROLL_SENSITIVE) ;
    rs.setConcurrency (ResultSet.CONCUR_UPDATABLE) ;  
    rs.setCommand (commande) ;
    rs.execute();
      // petite mise � jour du premier enregistrement
    rs.first() ;
    rs.updateString (2, "Modif1234") ;
    rs.updateRow(); 
    rs.acceptChanges() ; // indispensable ici -> Lance la synchronisation des modifications que quand je le lui demande
    // en dehors de cela, l'objet est déconnecté de la base de données
      // liste dans l'ordre inverse
    String ref, name ;
    rs.afterLast ();
    while (rs.previous())
    { ref  = rs.getString (1) ; name  = rs.getString (2) ;
      System.out.println ("Ref : " + ref + " / nom : " + name) ;
    }
    rs.close();
  } 
}

