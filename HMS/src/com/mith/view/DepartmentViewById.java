package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DepartmentDao;
import com.mith.model.Department;

/**
 * Servlet implementation class DepartmentViewById
 */
@WebServlet("/DepartmentViewById")
public class DepartmentViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String deptid=request.getParameter("deptid");
		Department d=DepartmentDao.displayById(deptid);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=DepartmentEditDelete method=post>");
		out.println("<center>");
		out.println("<table border=1 bgcolor=skyblue>");
		out.println("<caption><h3><i>Department Register</i></h3></caption>");
		out.println("<tr><td><b><i>Department Id:</i></b></td><td><input type=text size=15 name=deptid value='"+d.getDeptid()+"'></td></tr>");
		out.println("<tr><td><b><i>Department Name:</i></b></td><td><input type=text size=30 name=deptn value='"+d.getDeptName()+"'></td></tr>");
		out.println("<tr><td><b><i>Department Description:</i></b></td><td><input type=text name=deptdesc size=500 value='"+d.getDeptDescription()+"'></td></tr>");
		out.println("<tr><td><input name=btn type=submit value=Edit>&nbsp;&nbsp;&nbsp;&nbsp;<input name=btn type=submit value=Delete></td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</html>");}

}
