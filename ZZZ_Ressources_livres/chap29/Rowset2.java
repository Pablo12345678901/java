package zzz_ressources_livres.chap29;
import java.sql.* ;
//import com.sun.rowset.CachedRowSetImpl ;   // ou sun.rowset.CachedRowSetImpl
import javax.sql.rowset.* ;   // pour CachedRowSet

public class Rowset2
{ public static void main (String[] args) throws ClassNotFoundException, SQLException
  { Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ; 
    //CachedRowSet rs = new CachedRowSetImpl () ;
    CachedRowSet rs = RowSetProvider.newFactory().createCachedRowSet() ; // modifié par moi
    rs.setUrl ("jdbc:derby:C:/Documents and Settings/claude/stocks");
    rs.setType (ResultSet.TYPE_SCROLL_SENSITIVE) ;
    rs.setConcurrency (ResultSet.CONCUR_UPDATABLE) ;  
    rs.setCommand ("SELECT nom, quantite FROM produits") ;
    rs.execute();
      // petite mise � jour du premier enregistrement
    rs.first() ;
    rs.updateString (1, "Cafeti�re 15 T") ;
    rs.updateRow(); 
    rs.acceptChanges() ; // indispensable ici
      // liste dans l'ordre inverse
    String nom ; int qte ;
    rs.afterLast ();
    while (rs.previous())
    { nom  = rs.getString (1) ; qte  = rs.getInt (2) ;
      System.out.println (nom + " " + qte) ;
    }
    rs.close();
  } 
}
