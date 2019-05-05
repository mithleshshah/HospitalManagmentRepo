package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.MedicineDao;


/**
 * Servlet implementation class MedicineList
 */
@WebServlet("/MedicineList")
public class MedicineList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=MedicineDao.displayAll();
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		try{
		if(rs.next())
		{
			
			out.println("<center><table border=1 width=100%>");
			  out.println("<caption><h3>Medicine List</h3></Caption>");
	          out.println("<tr><th><font color=darkorange>Medicine no</font></th><th><font color=darkorange>Medicine Name</font></th><th><font color=darkorange>Medicine Category</font></th><th><font color=darkorange>Description</font></th><th><font color=darkorange>Price</font></th><th><font color=darkorange>Manufacturing Company</font></th><th><font color=darkorange>Status</font></th><th><font color=darkorange>Action</font></th></tr>");			
			  do
			  {
			 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td><a href=MedicineViewByNo?mno="+rs.getString(1)+">Edit/Delete</a></tr>");	  
				  
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
		}}

}
