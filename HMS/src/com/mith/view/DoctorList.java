package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DepartmentDao;
import com.mith.dao.DoctorDao;

/**
 * Servlet implementation class DoctorList
 */
@WebServlet("/DoctorList")
public class DoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=DoctorDao.displayAll();
		try{
			out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		if(rs.next())
		{
			out.println("<link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
			out.println("<body>");
			out.println("<center><table border=1 width=100%>");
			  out.println("<h3>Doctor List</h3>");
	          out.println("<tr><th><font color=darkorange>Doctor Id</font></th><th><font color=darkorange>Doctor Name</font></th><th><font color=darkorange>Department</font></th><th><font color=darkorange>Action</font></th></tr>");			
			  do
			  {
			 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(7)+"</td><td><a href=DoctorViewById?did="+rs.getString(1)+">Edit/Delete</a></tr>");	  
				  
			  }while(rs.next());
				out.println("</table></center>");
				out.println("</body>");
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
