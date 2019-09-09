package com.metacube.assignment;

import java.io.IOException;  
import java.io.PrintWriter;  
  


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {  
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
		
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        request.getRequestDispatcher("index.html").include(request, response);  
          
        String email = request.getParameter("email");  
        String password=request.getParameter("password");  
          
        if(email.equals("surender.sengwa@metacube.com") && password.equals("surender123")){  
        	
        	out.print("Welcome, " + email + ". You have successfully logged in !!");
        	out.println(" You have successfully logged in !!");
        	
        	HttpSession session = request.getSession();  
        	session.setAttribute("email", email);  
        	session.setMaxInactiveInterval(300);
        	response.sendRedirect("home.html");
        	
        } else {  
        	if(!email.equals("surender.sengwa@metacube.com")) {
            	out.print("<script>window.alert('unregistered email!!');</script>");
            	
            } else if(!password.equals("surender123")) {
            	out.print("<script>window.alert('wrong password!!');</script>");
            }
        	
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.forward(request, response);
        }  
        out.close();  
    }  
}  