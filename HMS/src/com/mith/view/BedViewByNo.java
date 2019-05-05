package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.NBedDao;
import com.mith.model.NBed;

/**
 * Servlet implementation class BedViewByNo
 */
@WebServlet("/BedViewByNo")
public class BedViewByNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BedViewByNo() {
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
		NBed b=NBedDao.displayById(bno);
		if(b!=null)
		{
			out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=BedEditDelete>");
		out.println("<table>");
		out.println("<caption><b><i>Add Bed</i></b></caption>");
		out.println("<tr><td>Bed number:</td><td><input type=text size=30 name=bno value='"+b.getBedNo()+"' readonly=true></td></tr>");
		out.println("<tr><td>Ward:</td><td>");
		out.println("<select name=wtyp>");
		out.println("<option value=w1>Ward-1</option>");
		out.println("<option value=w2>Ward-2</option>");
		out.println("<option value=w3>Ward-3</option>");
		out.println("<option value='"+b.getWard()+"'></option>");
		out.println("</select></td></tr>");
		out.println("<tr><td>Description:</td><td><input type=text size=100 name=desc value='"+b.getDescription()+"'></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form></html>");
		}
		
	}

}
