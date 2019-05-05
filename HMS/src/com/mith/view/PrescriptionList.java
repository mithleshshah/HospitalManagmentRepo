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


/**
 * Servlet implementation class PrescriptionList
 */
@WebServlet("/PrescriptionList")
public class PrescriptionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=PrescriptionDao.displayAll();
		try{
		if(rs.next())
		{
			out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
			out.println("<center><table border=1 width=100%>");
			  out.println("<caption><h3>Prescription List</h3></Caption>");
	          out.println("<tr><th><font color=darkorange>Prescription No.</font></th><th><font color=darkorange>Doctor</font></th><th><font color=darkorange>Patient</font></th><th><font color=darkorange>View Prescription</font></th><th><font color=darkorange>Action</font></th></tr>");			
			  do
			  {
			 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><a href=PrescriptionViewByPatient?pname="+rs.getString(3)+">Prescription</a></td><td><a href=PrescriptionViewByNo?pno="+rs.getString(1)+">Edit/Delete</a></td></tr>");	  
				  
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

}
