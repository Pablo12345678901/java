   <%-- Commentaire : code de determination des valeurs debut et fin --%>
<%  String sDeb = request.getParameter("debut") ;
    String sFin = request.getParameter("fin") ;
    long debut, fin ;
    if (sDeb == null) debut=1 ;
        else debut = Long.parseLong (sDeb);
    if (sFin == null) fin=4 ;
        else fin = Long.parseLong (sFin);
 %>
 <%! public String salut() { return "Salut" + "<br>" ; } %>
 <%! long fact(long nb)
  {  long resultat = 1 ;
    for (long i = 1; i<=nb; i++) resultat *= i ;
    return resultat ;
  }
%>
   
 <%-- Commentaire : construction de la page HTML --%>
<html>
 <head>   
  <title> JSP Calcul de factorielles </title>
 </head>
 <body>  
   Factorielles de <%= debut %> a <%= fin %> <br> <%-- Expressions --%>
     <% for (long i = debut ; i <= fin ; i++)
            { if (i >= debut)
              { long fac = fact(i) ;
      %>
                <%= i %>! =  <%= fac %> <br>
      <%          
              }
              else break ;
            }
      %>
      <% String message = salut() ; %>
      <%= message %>
      <%= salut() %>
 </body>
</html>
