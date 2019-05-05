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
import com.mith.dao.PrescriptionDao;
import com.mith.model.Prescription;


/**
 * Servlet implementation class PrescriptionViewByNo
 */
@WebServlet("/PrescriptionViewByNo")
public class PrescriptionViewByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionViewByNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String pno=request.getParameter("pno");
		Prescription p=PrescriptionDao.displayById(pno);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=PrescriptionEditDelete>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Description</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Prescrption No:</i></b></td><td><input type=text name=pno size=15 value='"+p.getPno()+"' readonly=true></td>");
		out.println("<tr><td><b><i>Doctor:</i></b></td><td>");
        try{
         ResultSet rs = DoctorDao.displayAll();
         out.println("<select name=dname>");
         out.println("<option>Doctor</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select></td><td>'"+p.getPdname()+"'</tr></tr>"); 	 
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
       	 
         out.println("</select></td><td>'"+p.getPpname()+"'</td></tr>"); 	 
        }catch(Exception e){}
		out.println("<tr><td><b><i>Case history</i></b></td><td><input type=text size=150 name=chp value='"+p.getPcs()+"'></td></tr>");
		out.println("<tr><td><b><i>Medication:</i></b></td><td><input type=text size=150 name=mdp value='"+p.getPmd()+"'></td></tr>");
		out.println("<tr><td><b><i>Medication from <br> Pharmacist:</i></b></td><td><input type=text size=150 name=mdpp value='"+p.getPmdp()+"'></td></tr>");
		out.println("<tr><td><b><i>Description:</i></b></td><td><input type=text size=150 name=desp value='"+p.getPdesc()+"'></td></tr>");
		out.println("<tr><td><b><i>Date:</i></b></td><td><input type=date name=pdate value='"+p.getPdate()+"'></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
	}

}
