package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.MCategoryDao;

/**
 * Servlet implementation class MedView
 */
@WebServlet("/MedView")
public class MedView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedView() {
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
		out.println("<form action=MedicineSubmit>");
		out.println("<center><table>");
		out.println("<caption><b><i>Add Medicine</i></b></caption>");
		out.println("<tr><td>Medicine no:</td><td><input type=text size=30 name=mno></td></tr>");
		out.println("<tr><td>Name:</td><td><input type=text size=30 name=mname></td></tr>");
		out.println("<tr><td>Medicine category:</td></td><td>");
        try{
         ResultSet rs = MCategoryDao.displayAll();
         out.println("<select name=mcname>");
         out.println("<option>Category</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select>"); 	 
        }catch(Exception e){}
		out.println("<tr><td>Description:</td><td><textarea rows=4 cols=30 name=mdesc></textarea></td></tr>");
		out.println("<tr><td>Price:</td><td><input type=text size=10 name=mprice></td></tr>");
		out.println("<tr><td>Company Name:</td><td><input type=text size=30 name=cname></td></tr>");
		out.println("<tr><td>Status:</td><td><input type=text size=30 name=mstatus></td></tr>");
		out.println("<tr><td><input type=submit></td><td><input type=reset ></td></tr>");
		out.println("</table></center>");
		out.println("</form></html>");
	}

}
