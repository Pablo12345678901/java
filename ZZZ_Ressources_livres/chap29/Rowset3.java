package zzz_ressources_livres.chap29;
import java.sql.* ;
import com.sun.rowset.CachedRowSetImpl ;   // ou sun.rowset.CachedRowSetImpl
//import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.* ;   // pour CachedRowSet
public class Rowset3
{ public static void main (String[] args) throws ClassNotFoundException, SQLException
  { Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ; 
    Connection connec = DriverManager.getConnection
          ("jdbc:derby:C:/Documents and Settings/claude/stocks");
      // cr�ation d'un ResultSet 
    String commande = "SELECT nom, quantite FROM produits" ;
    Statement stmt = connec.createStatement() ;
    ResultSet res ;
    res = stmt.executeQuery(commande);
       // cr�ation d'un RowSet enveloppe du ResultSet et utilisation
    CachedRowSet rs = new CachedRowSetImpl() ;
    rs.populate(res) ;   // on peuple le CachedRowSet avec les donn�es du ResultSet
       // petite mise � jour du premier enregistrement
    rs.first() ;
    rs.updateString (1, "Cafeti�re 18 T") ;
    rs.updateRow(); 
    rs.acceptChanges(connec) ; // indispensable de fournir ici les infos de connexion
      // liste dans l'ordre inverse
    String nom ; int qte ;
    rs.afterLast ();
    while (rs.previous())
    { nom  = rs.getString (1) ; qte  = rs.getInt (2) ;
      System.out.println (nom + " " + qte) ;
    }
    rs.close(); res.close () ;
  }
}
