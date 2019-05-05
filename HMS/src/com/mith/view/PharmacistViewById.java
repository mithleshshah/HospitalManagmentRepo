package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.PharmacistDao;
import com.mith.model.Pharmacist;


/**
 * Servlet implementation class PharmacistViewById
 */
@WebServlet("/PharmacistViewById")
public class PharmacistViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacistViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String phid=request.getParameter("phid");
		Pharmacist p=PharmacistDao.displayById(phid);
		if(p!=null)
		{
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=PharmacistEditDelete>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Pharmacist</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Pharmacist Id:</i></b></td><td><input type=text size=30 name=phid value='"+p.getPharmacistId()+"'></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=phname value='"+p.getPhName()+"'></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=phemail value='"+p.getPhEmail()+"'></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password size=30 name=phpwd value='"+p.getPhpwd()+"'></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=text size=100 name=phadd value='"+p.getPhadd()+"'></td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=phph value='"+p.getPhph()+"'></td></tr>");
		out.println("<tr><td><input name=btn type=submit value=Edit></td><td><input name=btn type=submit value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
		}}

}
