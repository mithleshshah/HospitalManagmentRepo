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
import com.mith.dao.MedicineDao;
import com.mith.model.Medicine;

/**
 * Servlet implementation class MedicineViewByNo
 */
@WebServlet("/MedicineViewByNo")
public class MedicineViewByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineViewByNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String mno=request.getParameter("mno");
		Medicine m=MedicineDao.displayById(mno);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=MedicineEditDelete>");
		out.println("<table>");
		out.println("<caption><b><i>Add Medicine</i></b></caption>");
		out.println("<tr><td>Medicine no:</td><td><input type=text size=30 name=mno value='"+m.getMedNo()+"'></td></tr>");
		out.println("<tr><td>Name:</td><td><input type=text size=30 name=mname value='"+m.getMName()+"'></td></tr>");
		out.println("<tr><td>Medicine category:</td></td><td>");
        try{
         ResultSet rs = MCategoryDao.displayAll();
         out.println("<select name=mcname>");
         out.println("<option value='"+m.getMCategory()+"'>Category</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select></td><td>'"+m.getMCategory()+"'</td></tr>"); 	 
        }catch(Exception e){}
		out.println("<tr><td>Description:</td><td><input type=text size=100 name=mdesc value='"+m.getMdescription()+"'></td></tr>");
		out.println("<tr><td>Price:</td><td><input type=text size=10 name=mprice value='"+m.getMPrice()+"'></td></tr>");
		out.println("<tr><td>Company Name:</td><td><input type=text size=30 name=cname value='"+m.getMCName()+"'></td></tr>");
		out.println("<tr><td>Status:</td><td><input type=text size=30 name=mstatus value='"+m.getMStatus()+"'></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete ></td></tr>");
		out.println("</table>");
		out.println("</form></html>");
	}

}
