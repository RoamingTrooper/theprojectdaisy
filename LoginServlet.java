

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		boolean isAuthenticate = authenticateUser(username,password);
		if (isAuthenticate) {
			out.println("<h2> Welcome,"+ username + "!</h2>");
		}
		else
		{
			out.println("<h2> Invalid Username and Password!</h2>");
		}
		
		
	}
	private boolean authenticateUser(String username, String password) {
		return "altaf".equals(username) && "altaf".equals(password);
     }
}

