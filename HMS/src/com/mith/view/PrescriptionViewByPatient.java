package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.PrescriptionDao;
import com.mith.model.Prescription;

/**
 * Servlet implementation class PrescriptionViewByPatient
 */
@WebServlet("/PrescriptionViewByPatient")
public class PrescriptionViewByPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionViewByPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String pname=request.getParameter("pname");
		Prescription p=PrescriptionDao.displayByPname(pname);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<a href=PrescriptionList>Click here to go back to Prescription List</a>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Description</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Prescrption No:</i></b></td><td>'"+p.getPno()+"'</td></tr>");
		out.println("<tr><td><b><i>Doctor:</i></b></td><td>'"+p.getPdname()+"'</td></tr>");
		out.println("<tr><td><b><i>Patient:</i></b></td><td>'"+p.getPpname()+"'</td></tr>");
		out.println("<tr><td><b><i>Case history</i></b></td><td>'"+p.getPcs()+"'</td></tr>");
		out.println("<tr><td><b><i>Medication:</i></b></td><td>'"+p.getPmd()+"'</td></tr>");
		out.println("<tr><td><b><i>Medication from <br> Pharmacist:</i></b></td><td>'"+p.getPmdp()+"'</td></tr>");
		out.println("<tr><td><b><i>Description:</i></b></td><td>'"+p.getPdesc()+"'</td></tr>");
		out.println("<tr><td><b><i>Date:</i></b></td><td><input type=date value="+p.getPdate()+"></td></tr>");
		out.println("</table>");
		out.println("</html>");
	}

}
