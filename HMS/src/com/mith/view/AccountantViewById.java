package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.AccountantDao;
import com.mith.dao.NurseDao;
import com.mith.model.Accountant;
import com.mith.model.Nurse;

/**
 * Servlet implementation class AccountantViewById
 */
@WebServlet("/AccountantViewById")
public class AccountantViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String acid=request.getParameter("acid");
		Accountant a=AccountantDao.displayById(acid);
		if(a!=null)
		{
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=AccountantEditDelete method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Accountant</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Accountant Id:</i></b></td><td><input type=text size=30 name=acid value='"+a.getAccountantId()+"'></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=acname value='"+a.getAName()+"'></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=acemail value='"+a.getAEmail()+"'></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password size=30 name=acpwd value='"+a.getApwd()+"'></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=text size=100 name=acadd value='"+a.getAadd()+"'></td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=acph value='"+a.getAph()+"'></td></tr>");
		out.println("<tr><td><b><i>Image:</i></b></td><td><input type=file size=40 name=aicon></td><td><img src='pic/"+a.getAicon()+"' width=50 height=50></td></tr>");
		out.println("<tr><td><input name=btn type=submit value=Edit></td><td><input name=btn type=submit value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
