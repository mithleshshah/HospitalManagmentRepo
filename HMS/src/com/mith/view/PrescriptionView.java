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
 * Servlet implementation class PrescriptionView
 */
@WebServlet("/PrescriptionView")
public class PrescriptionView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionView() {
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
		out.println("<form action=PrescriptionSubmit>");
		out.println("<center><table>");
		out.println("<tr><caption><h3><i>Add Prescription</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Prescrption No:</i></b></td><td><input type=text name=pno size=15></td>");
		out.println("<tr><td><b><i>Doctor:</i></b></td><td>");
        try{
         ResultSet rs = DoctorDao.displayAll();
         out.println("<select name=dname>");
         out.println("<option>Doctor</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select></td></tr>"); 	 
        }catch(Exception e){}
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
		out.println("<tr><td><b><i>Case history</i></b></td><td><textarea rows=3 cols=50 name=chp></textarea></td></tr>");
		out.println("<tr><td><b><i>Medication:</i></b></td><td><textarea rows=3 cols=50 name=mdp></textarea></td></tr>");
		out.println("<tr><td><b><i>Medication from <br> Pharmacist:</i></b></td><td><textarea rows=3 cols=50 name=mdpp></textarea></td></tr>");
		out.println("<tr><td><b><i>Description:</i></b></td><td><textarea rows=3 cols=50 name=desp></textarea></td></tr>");
		out.println("<tr><td><b><i>Date:</i></b></td><td><input type=date name=pdate></td></tr>");
		out.println("<tr><td><input type=submit></td><td><input type=reset></td></tr>");
		out.println("</table></center>");
		out.println("</form>");
		out.println("</html>");
	}

}
