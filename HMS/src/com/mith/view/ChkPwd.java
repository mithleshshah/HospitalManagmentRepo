package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mith.dao.AdminDao;
import com.mith.model.Admin;

/**
 * Servlet implementation class ChkPwd
 */
@WebServlet("/ChkPwd")
public class ChkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChkPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Admin A=AdminDao.checkPassword(request.getParameter("uname"),request.getParameter("pwd"));
		if(A==null)
		{ PrintWriter out=response.getWriter();
		response.sendRedirect("LoginPage");
		}
		else
		{
			HttpSession ses=request.getSession();
			ses.putValue("SAID",A.getAdminid());
			ses.putValue("SANAME", A.getAdminname());
			ses.putValue("LTIME",new java.util.Date());	
		response.sendRedirect("MyHomePage");	
		}
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
