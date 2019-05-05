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

/**
 * Servlet implementation class DAppointment
 */
@WebServlet("/DAppointment")
public class DAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=DAppointmentSubmit method=post enctype='multipart/form-data'>");
		out.println("<center>");
		out.println("<table border=1 bgcolor=skyblue>");
		out.println("<tr><caption><h3><i>Doctor Appointment</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Patient Id:</i></b></td><td><input type=text size=15 name=aid></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=dname></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=demail></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><textarea rows=4 cols=30 name=dadd></textarea></td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=dph></td></tr>");
		out.println("<tr><td><b><i>Consultation for:</b></i></td><td>");
		         try{
		          ResultSet rs = DepartmentDao.displayAll();
		          out.println("<select name=ddept>");
		          out.println("<option>Department</option>");
		          while(rs.next())
		          {
		           out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
		          }
		        	 
		          out.println("</select>"); 	 
		         }catch(Exception e){}
		         out.println("<tr><td><b><i>Date:</i></b></td><td><input type=Date size=30 name=ddate></td></tr>");
		 		out.println("<tr><td><b><i>Image:</i></b></td><td><input type=file size=50 name=dicon></td></tr>");
		         out.println("<tr><td><input type=submit></td><td><input type=reset></td></tr>");
		         out.println("</table>");
		         out.println("</center></form>");
		         out.println("</html>");
	}

}
