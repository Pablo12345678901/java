<html>
    <head>   
        <title> Bonjour </title>
        <%@ page contentType="text/html; charset=UTF-8" %>
        <%-- Ceci sert à configurer l'encodage UTF-8 et bénéficier des accents--%>
    </head>
    <body>  
        <%  // Commentaire java
            String prenom = request.getParameter ("prenom") ;
            String nom = request.getParameter ("nom") ;
            out.println("prenom = null : " + (prenom == "") + "<br>" + "nom = null : " + (nom == "") + "<br>") ;
        %>
        Équivalent en expression :
        <br>
        prenom = null : <%= (prenom == "") %>
        <br>
        nom = null : <%= (nom == "") %>
        <br>
        <%  if (prenom == "" && nom == "" )
            out.println("Bonjour" + "<br>") ;
            else if  (prenom == "") out.println("Bonjour" + " M/Mme " + nom + "<br>") ;
            else if (nom == "")
            {   out.println("Salut " + prenom + "<br>") ;
        %>  
        <!-- else out.println("Bonjour" + " M/Mme " + prenom + " " + nom + "<br>") ; -->
        <%  }
            else 
            {
        %>
            Bonjour <%= prenom %> <%= nom %>
        <%  }
        %>
    </body>
</html>
