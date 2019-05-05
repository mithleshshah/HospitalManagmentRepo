package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.PatientDao;


/**
 * Servlet implementation class DAppointmentView
 */
@WebServlet("/DAppointmentView")
public class DAppointmentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DAppointmentView() {
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
		out.println("<form action=AppointmentSubmit>");
		out.println("<center><table>");
		out.println("<tr><caption><h3><b><i>Add Appointment</i></b></h3></caption></tr>");
		out.println("<tr><td><b><i>Appointment No.:</i></b></td><td><input type=text size=20 name=apno></td></tr>");
		out.println("<tr><td><b><i>Doctor:</i></b></td><td><input type=text size=20 value=Doctor name=dname></td></tr>");
		out.println("<tr><td><b><i>Patient:</i></b></td><td>");
        try{
         ResultSet rs = PatientDao.displayAll();
         out.println("<select name=pname>");
         out.println("<option>Patient</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select>"); 	 
        }catch(Exception e){}
		out.println("<tr><td><b><i>Date:</i></b></td><td><input type=date size=20 name=adate></td></tr>");
		out.println("<tr><td><input type=submit></td><td><input type=reset></td></tr>");
		out.println("</table></center>");
		out.println("</form>");
		out.println("</html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
