package ZZZ_Ressources_livres.chap28;
import java.sql.* ;
import javax.sql.rowset.* ;   // pour RowSet
import com.sun.rowset.JdbcRowSetImpl ;  // indispensable   
public class  Rowset
{ public static void main (String[] args) throws ClassNotFoundException, SQLException
  { Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ; 
    Connection connec = DriverManager.getConnection
          ("jdbc:derby:C:/Documents and Settings/claude/stocks2");
      // cr�ation d'un ResultSet 
    String commande = "SELECT nom, quantite FROM produits" ;
    Statement stmt = connec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                      ResultSet.CONCUR_UPDATABLE) ;
    ResultSet res ;
    res = stmt.executeQuery(commande);
      // cr�ation d'un RowSet enveloppe du ResultSet et utilisation
    JdbcRowSet rs = new JdbcRowSetImpl (res) ;
    String nom ; int qte ;
      // petite mise � jour
    rs.first() ;
    rs.updateString (1, "Cafeti�re 6 T") ;
    rs.updateRow();
      // liste dans l'ordre inverse
    rs.afterLast();
    while (rs.previous())
    { nom  = rs.getString (1) ; qte  = rs.getInt (2) ;
      System.out.println (nom + " " + qte) ;
    }
    stmt.close () ; res.close (); rs.close (); connec.close () ;
  }
}
