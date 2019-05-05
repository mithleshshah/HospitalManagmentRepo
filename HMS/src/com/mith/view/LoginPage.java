package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        out.println("<html>"
        		+ "<head>"
        		+ "<title>Login To Hospital Management System</title>"
        		+ "<meta charset='utf-8'>"
        				+ "<link href='style.css' rel='stylesheet' type='text/css' />"
        						+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
        						+ "<script type='application/x-javascript'> addEventListener('load', function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>"
        								+ "<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>"
        								+ "</head>"
        								+ "<body>"
        	+"<div class='login-form'>"
        		+"<div class='head'>"
        		+"<img src='usrpic/mem2.jpg' width=120 height=120 alt=''/>"
        				+ "</div>"
        				+ "<form action=ChkPwd method=post>"
        				
        										+ "<li>"
        										+ "<input type=text class='text' name=uname size=30><a href='#' class=' icon user'></a>"
        												+ "</li>"
        												+ "<li>"
        												+ "<input type=password name=pwd><a href='#' class=' icon lock'></a>"
        														+ "</li>"
        														+ "<div class='p-container'>"
        																+ "<input type=submit value=Log IN >"
        																		+ "<div class='clear'> </div>"
        																				+ "</div>"
        																				+ "</form>"
        																				+ "</div>"
        																				+ "</body>"
        																				+ "</html>"); 
                
		out.flush();
		}

}
