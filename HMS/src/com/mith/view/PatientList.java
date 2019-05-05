package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DoctorDao;
import com.mith.dao.PatientDao;

/**
 * Servlet implementation class PatientList
 */
@WebServlet("/PatientList")
public class PatientList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=PatientDao.displayAll();
		try{
		if(rs.next())
		{
			out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
			out.println("<center><table border=1 width=100%>");
			  out.println("<caption><h3>Patient List</h3></Caption>");
	          out.println("<tr><th><font color=darkorange>Patient Id</font></th><th><font color=darkorange>Patient Name</font></th><th><font color=darkorange>Age</font></th><th><font color=darkorange>Sex</font></th><th><font color=darkorange>Blood Group</font></th><th><font color=darkorange>Birth Date</font></th><th><font color=darkorange>Action</font></th></tr>");			
			  do
			  {
			 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(8)+"</td><td><a href=PatientViewById?pid="+rs.getString(1)+">Edit/Delete</a></tr>");	  
				  
			  }while(rs.next());
				out.println("</table></center>");
			}
			else
			{
			out.println("<h3><font color=red>Record Not Found</font></h3>");	
				
			}	
		}
		catch(Exception e){
			
			System.out.println(e);
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
