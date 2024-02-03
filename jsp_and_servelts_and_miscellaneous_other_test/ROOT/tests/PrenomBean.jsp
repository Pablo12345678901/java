<%-- creation d'un objet de type PrenomBean --%>
<jsp:useBean id="objetPrenom" class="beans.PrenomBean" />
 <head>   
  <title> JSP Essai Bean </title>
  <%@ page contentType="text/html; charset=UTF-8" %>
 </head>
 <body>
   <jsp:setProperty name="objetPrenom" property="prenom" value="Pablo" />
   BONJOUR <jsp:getProperty name="objetPrenom" property="prenom" /> <br>
 </body>
</html>
