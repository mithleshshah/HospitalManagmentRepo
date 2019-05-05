package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.LaboratoristDao;
import com.mith.model.Laboratorist;

/**
 * Servlet implementation class LaboratoristViewById
 */
@WebServlet("/LaboratoristViewById")
public class LaboratoristViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaboratoristViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String lid=request.getParameter("lid");
		Laboratorist l=LaboratoristDao.displayById(lid);
		if(l!=null)
		{
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=LaboratoristEditDelete>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Accountant</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Laboratorist Id:</i></b></td><td><input type=text size=30 name=lid value='"+l.getLaboratoristId()+"'></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=lname value='"+l.getLName()+"'></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=lemail value='"+l.getLEmail()+"'></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password size=30 name=lpwd value='"+l.getLpwd()+"'></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=text size=100 name=ladd value='"+l.getLadd()+"'></td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=lph value='"+l.getLph()+"'></td></tr>");
		out.println("<tr><td><input name=btn type=submit value=Edit></td><td><input name=btn type=submit value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
