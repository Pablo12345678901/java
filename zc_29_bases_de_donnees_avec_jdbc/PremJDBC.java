import java.sql.* ;    // pour SQLException, DriverManager, Statement, ResultSet

public class PremJDBC         
{ public static void main (String[] args) 
      throws ClassNotFoundException, SQLException  // on ne traite pas les exceptions
  {   // recherche et enregistrement du pilote (driver)
     Class.forName ("org.apache.derby.jdbc.EmbeddedDriver") ;
      // �tablissement de la connexion avec la base stocks (cr��e ici avec Derby)
     Connection connec = DriverManager.getConnection
                        ("jdbc:derby:stocks"); // nom du répertoire de la DB 
      // cr�ation de l'objet de type Statement associ� � la connexion, contenant 
      //   une requ�te SQL (ici de s�lection de donn�es)
    String requete = "SELECT REF, NAME FROM FOURNISSEURS" ; // nom de la base de données
    Statement stmt = connec.createStatement() ;
      // ex�cution de la requ�te SQL de s�lection de donn�es
    ResultSet res ;
    res = stmt.executeQuery(requete); // on envoie la requête et reçoit en échange le résultat
      // r�cup�ration et affichage des r�sultats de la s�lection
    String ref ;
    String name ;
    while (res.next()) // .next déplace le curseur et renvoie null comme résultat si je suis après la fin (ou avant le début)
    // raison pour laquelle la boucle commence avec cette instruction
    {  ref = res.getString(1) ;        // premi�re colonne du r�sultat
         name = res.getString (2) ;     // deuxi�me colonne du r�sultat
       System.out.println (ref + " " + name) ;
    }
      // libération des ressources
    stmt.close() ;
    res.close();
    connec.close();
  }  
}
