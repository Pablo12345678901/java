package zzz_ressources_livres.chap29;
import java.sql.* ;
import javax.sql.rowset.* ;   // pour RowSet
//import java.sql.rowset.com.sun.rowset.JdbcRowSetImpl ;  // indispensable
//import java.sql.rowset.javax.sql.rowset.JdbcRowSet ;
//import com.sun.rowset.JdbcRowSetImpl;
//import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;


public class  Rowset
{ public static void main (String[] args) throws ClassNotFoundException, SQLException
  { Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ; 
    Connection connec = DriverManager.getConnection
          ("jdbc:derby:C:/Documents and Settings/claude/stocks2");
      // cr�ation d'un ResultSet 
    //String commande = "SELECT nom, quantite FROM produits" ;
    String commande = "SELECT nom, quantite, reference FROM produits" ; // modif par moi
    Statement stmt = connec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                      ResultSet.CONCUR_UPDATABLE) ;
    ResultSet res ;
    res = stmt.executeQuery(commande);
      // cr�ation d'un RowSet enveloppe du ResultSet et utilisation
    //JdbcRowSet rs = new JdbcRowSetImpl (res) ;
    JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet() ; // modifié par moi
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
