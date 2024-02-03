package servlets;
import java.io.* ;
import jakarta.servlet.* ;
import jakarta.servlet.http.* ;

public class Bonjour extends HttpServlet
{ public void doGet (HttpServletRequest req, HttpServletResponse rep)
              throws IOException, ServletException
  { rep.setContentType ("text/html") ;
    PrintWriter page = rep.getWriter() ;
    page.println ("<html>") ;
    page.println ("<head>") ;
    page.println ("<title> Servlet Bonjour </title>") ;
    page.println ("</head>") ;
    page.println ("<body>") ;
       page.println ("<font size=+2>") ;
       page.println ("BONJOUR Don Vito !") ;
       page.println ("</body>") ;
    }
}
