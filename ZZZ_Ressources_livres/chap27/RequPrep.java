package ZZZ_Ressources_livres.chap27;
import java.sql.* ;    // pour SQLException, DriverManager, Statement, ResultSet
public class RequetePrep         
{ public static void main (String[] args) 
              throws ClassNotFoundException, SQLException 
  {   // tableau des r�f�rences cherch�es dans la table produit
    String[] refCherchees = { "E248", "A427", "A432" } ;
      // recherche pilote et �talissement connexion
    Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ;
    Connection connec = DriverManager.getConnection
                ("jdbc:derby:C:/Documents and Settings/claude/stocks");
      //  cr�ation de l'objet de type PreparedStatement associ� � la connexion
      //  contenant une requ�te pr�par�e � un param�tre
    String requetePrep = "SELECT * FROM produits WHERE REFERENCE = ?" ;
    PreparedStatement prepStmt = connec.prepareStatement(requetePrep) ;
      //   pour chaque r�f�rence cherch�e, on cr��e un objet ResultSet  
    ResultSet res ;
    for (int i = 0 ; i< refCherchees.length ; i++)
    { prepStmt.setString (1, refCherchees[i] ) ;	
      res = prepStmt.executeQuery();
      System.out.println ("---- produits de reference : " + refCherchees[i]) ;
      while (res.next()) // pour se placer sur la premi�re ligne si elle existe
      { String nom = res.getString (1) ;
        int qte = res.getInt (4) ;
        System.out.println (nom + " " + refCherchees[i] + " " + qte) ;
      }  
      res.close();
    }   
      // lib�ration des ressources
    prepStmt.close() ;
    connec.close();
  }  
}
