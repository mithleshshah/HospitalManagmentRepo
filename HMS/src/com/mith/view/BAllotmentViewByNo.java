package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.BedAllotmentDao;
import com.mith.dao.PatientDao;
import com.mith.model.BedAllotment;

/**
 * Servlet implementation class BAllotmentViewByNo
 */
@WebServlet("/BAllotmentViewByNo")
public class BAllotmentViewByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BAllotmentViewByNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String bno=request.getParameter("bno");
		BedAllotment b=BedAllotmentDao.displayById(bno);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=DBedAllotmentEditDelete>");
		out.println("<table>");
		out.println("<caption><h3><b><i>Add Bed Allotment</i></b></h3></caption>");
		out.println("<tr><td><b><i>Bed Number:</i></b></td><td><input type=text name=bno size=10 value='"+b.getBno()+"' readonly=true></td>");
		out.println("<tr><td><b><i>Ward:</i></b></td><td>");
		out.println("<select name=wno>");
		out.println("<option>Ward</option>");
		out.println("<option value=w1>Ward-1</option>");
		out.println("<option value=w2>Ward-2</option>");
		out.println("<option value=w3>Ward-3</option>");
		out.println("</select></td><td>'"+b.getWard()+"'</td>/tr>");
		out.println("<tr><td><b><i>Patient:</i></b></td><td>");
        try{
         ResultSet rs = PatientDao.displayAll();
         out.println("<select name=pname>");
         out.println("<option value='"+b.getPatient()+"'>Patient</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select></td><td>'"+b.getPatient()+"'</td></tr>"); 	 
        }catch(Exception e){}
        out.println("<tr><td><b><i>Allotment date:</i></b></td><td><input type=date size=15 name=dbadate value='"+b.getAllotmentDate()+"'></td></tr>");
		out.println("<tr><td><b><i>Discharge Date:</i></b></td><td><input type=date size=15 name=dbddate value='"+b.getDischargeDate()+"'></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit value=Delete name=btn></td></tr>");
		out.println("</table>");
		out.println("</form></html>");}

}
