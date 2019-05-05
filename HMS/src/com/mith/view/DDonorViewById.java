package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DDonorDao;
import com.mith.model.DDonor;

/**
 * Servlet implementation class DDonorViewById
 */
@WebServlet("/DDonorViewById")
public class DDonorViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DDonorViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String doid=request.getParameter("doid");
		DDonor d=DDonorDao.displayById(doid);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=DDonorEditDelete>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Blood Bank</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Donorid::</i></b></td><td><input type=text size=30 name=doid value='"+d.getDonorid()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=dname value='"+d.getDonorname()+"'></td></tr>");
		out.println("<tr><td><b><i>Age:</i></b></td><td><input type=text size=30 name=dage value='"+d.getDonorage()+"'></td></tr>");
		out.println("<tr><td><b><i>Sex:</i></b></td><td><input type=radio name=gend value=Male>Male&nbsp;&nbsp;&nbsp;&nbsp;<input type=radio value=Female name=gend>Female</td><td>'"+d.getDonorsex()+"'</td></tr>");
		out.println("<tr><td><b><i>Blood Group:</i></b></td><td><input type=text size=4 name=dgrp value='"+d.getBloodgroup()+"'></td></tr>");
		out.println("<tr><td><b><i>Last Donation Date:</i></b></td><td><input type=date size=15 name=ldate value='"+d.getLastdonationdate()+"'></td></tr>");
		out.println("<tr><td><input name=btn value=Edit type=submit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
	
	}

}
