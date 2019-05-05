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
import com.mith.dao.ReportDao;
import com.mith.model.Report;

/**
 * Servlet implementation class ReportViewByNo
 */
@WebServlet("/ReportViewByNo")
public class ReportViewByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportViewByNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String rno=request.getParameter("rno");
		Report r=ReportDao.displayById(rno);
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=ReportEditDelete method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><h3><b><i>Add Report</i></b></h3></caption>");
		out.println("<tr><td><b><i>Report Number:</i></b></td><td><input type=text name=rno size=10 value='"+r.getReportNo()+"' readonly=true></td>");
		out.println("<tr><td><b><i>Type:</i></b></td><td>");
		out.println("<select name=typ>");
		out.println("<option value='"+r.getType()+"'></option>");
		out.println("<option value=typ1>Operation</option>");
		out.println("<option value=typ2>Birth</option>");
		out.println("<option value=typ3>Death</option>");
		out.println("<option value=typ4>Other</option>");
		out.println("</select></td><td>'"+r.getType()+"'</td></tr>");
		out.println("<tr><td><b><i>Attach Report:</i></b></td><td><input type=file size=55 name=rpt value='"+r.getReport()+"'></td></tr>");
		out.println("<tr><td><b><i>Description:</i></b></td><td><input type=text size=100 name=rdesc value='"+r.getRdesc()+"'></td></tr>");
		out.println("<tr><td><b><i>Date:</i></b></td><td><input type=date size=15 name=rdate value='"+r.getRdate()+"'></td></tr>");
			
		out.println("<tr><td><b><i>Doctor:</i></b></td><td>");
        try{
         ResultSet rs = DoctorDao.displayAll();
         out.println("<select name=dname>");
         out.println("<option>Doctor</option>");
         while(rs.next())
         {
          out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(2)+"</option>");	  
         }
       	 
         out.println("</select></td><td>'"+r.getDocname()+"'</td></tr>"); 	 
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
       	 
         out.println("</select></td><td>'"+r.getPatname()+"'</td></tr>"); 	 
        }catch(Exception e){}
       out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form></html>");
		}

}
