<html>
 <head>   
  <title> JSP Bonjour avec une classe Prenom </title>
  <%@ page contentType="text/html; charset=UTF-8" %>
 </head>
 <body>  
  <%@ page import="zjspclass.*" %>
 <% zclassjava pr = new zclassjava() ;            // declaration d'un objet local du type classe Prenom
    String s = request.getParameter ("prenom") ; // recuperation parametre prenom
    if (s != null) pr.setPrenom (s) ;         
  %>
    BONJOUR <%= pr.getPrenom() %>
    <br>
    HELLO <%= pr.salut() %>
 </body>
</html>
