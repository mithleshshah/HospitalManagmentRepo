package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DAppointmentDao;
import com.mith.dao.PatientDao;
import com.mith.model.DAppointment;


/**
 * Servlet implementation class AppointmentViewByNo
 */
@WebServlet("/AppointmentViewByNo")
public class AppointmentViewByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentViewByNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String apno=request.getParameter("apno");
		DAppointment a=DAppointmentDao.displayById(apno);
		if(a!=null)
		{
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=AppointmentEditDelete>");
		out.println("<table>");
		out.println("<tr><caption><h3><b><i>Add Appointment</i></b></h3></caption></tr>");
		out.println("<tr><td><b><i>Appointment No.:</i></b></td><td><input type=text size=20 name=apno value='"+a.getApno()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Doctor:</i></b></td><td><input type=text size=20 value=Doctor name=dname value='"+a.getDoctor()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Patient:</i></b></td><td>");
        try{
         ResultSet rs = PatientDao.displayAll();
         out.println("<select name=pname>");
         out.println("<option value='"+a.getPatient()+"'>Patient</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select></td><td>'"+a.getPatient()+"'</td></tr>"); 	 
        }catch(Exception e){}
		out.println("<tr><td><b><i>Date:</i></b></td><td><input type=date size=20 name=adate value='"+a.getApdate()+"'></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
		
	}
	}
}
