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
import com.mith.model.Doctor;

/**
 * Servlet implementation class DoctorViewById
 */
@WebServlet("/DoctorViewById")
public class DoctorViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String docid=request.getParameter("did");
		Doctor d=DoctorDao.displayById(docid);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=DoctorEditDelete method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Doctor</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Doctor Id:</i></b></td><td><input type=text size=15 name=did value='"+d.getDoctorid()+"'></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=dname value='"+d.getDocName()+"'></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=30 name=demail value='"+d.getDEmail()+"'></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password size=30 name=dpwd value='"+d.getDpwd()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=text size=50  name=dadd value='"+d.getDAdress()+"'</td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=dph value='"+d.getDphone()+"'></td></tr>");
		out.println("<tr><td><b><i>Department:</b></i></td><td>");
		         try{
		          ResultSet rs = DepartmentDao.displayAll();
		          out.println("<select name=ddept>");
		          out.println("<option value='"+d.getDepartment()+"'>Department</option>");
		          while(rs.next())
		          {
		           out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
		          }
		        	 
		          out.println("</select>'"+d.getDepartment()+"'</td></tr>"); 	 
		         }catch(Exception e){
		        	 System.out.println(e);
		         }
		         out.println("<tr><td><b><i>Image:</i></b></td><td><input type=file size=50 name=dicon></td><td><img src='pic/"+d.getDIcon()+"' height=100 width=100></td></tr>");
		         out.println("<tr><td><input name=btn type=submit value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
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
