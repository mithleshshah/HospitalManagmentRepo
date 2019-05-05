package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.MCategoryDao;
import com.mith.model.MedCategory;

/**
 * Servlet implementation class MCatViewById
 */
@WebServlet("/MCatViewById")
public class MCatViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MCatViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String mcid=request.getParameter("mcid");
		MedCategory m=MCategoryDao.displayById(mcid);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=MCatEditDelete>");
		out.println("<table>");
		out.println("<caption><b><i>Add medicine category</i></b></caption>");
		out.println("<tr><td>Medicine Category Id.</td><td><input type=text size=30 name=mcid value='"+m.getMedCatId()+"' readonly=true></td></tr>");
		out.println("<tr><td>Medicine category:</td><td><input type=text size=30 name=medc value='"+m.getMedCat()+"'></td></tr>");
		out.println("<tr><td>Description:</td><td><input type=text size=100 name=meddesc value='"+m.getMedDesc()+"'></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form></html>");
	}

}
