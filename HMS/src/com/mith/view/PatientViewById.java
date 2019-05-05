package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.PatientDao;
import com.mith.model.Patient;

/**
 * Servlet implementation class PatientViewById
 */
@WebServlet("/PatientViewById")
public class PatientViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String pid=request.getParameter("pid");
		Patient p=PatientDao.displayById(pid);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=PatientEditDelete method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Patient</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Patient Id:</i></b></td><td><input type=text size=15 name=pid value='"+p.getPatientid()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=pname value='"+p.getPName()+"'></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=50 name=pemail value='"+p.getPEmail()+"'></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password size=30 name=ppwd value='"+p.getPpwd()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=text size=50 name=padd value='"+p.getPAdress()+"'></td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=pph value='"+p.getPphone()+"'></td></tr>");
		out.println("<tr><td><b><i>Sex:</i></b></td><td><input type=radio name=gend value=Male>Male&nbsp;&nbsp;&nbsp;&nbsp;<input type=radio value=Female name=gend>Female</td>&nbsp;&nbsp;&nbsp;&nbsp;<td>'"+p.getPsex()+"'</td></tr>");
		out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type=date size=20 name=pbd value='"+p.getPdob()+"'></td></tr>");
		out.println("<tr><td><b><i>Age:</i></b></td><td><input type=text size=4 name=page value='"+p.getPage()+"'></td></tr>");
		out.println("<tr><td><b><i>Blood Group:</i></b></td><td><input type=text size=4 name=pbg value='"+p.getPbg()+"'></td></tr>");
		out.println("<tr><td><b><i>Image:</i></b></td><td><input type=file name=picon size=40></td><td><img src='pic/"+p.getPicon()+"' height=100 width=100></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
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
