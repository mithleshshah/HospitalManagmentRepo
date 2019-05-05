package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.NurseDao;
import com.mith.model.Nurse;


/**
 * Servlet implementation class NurseViewById
 */
@WebServlet("/NurseViewById")
public class NurseViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String nid=request.getParameter("nid");
		Nurse n=NurseDao.displayById(nid);
		if(n!=null)
		{
		out.println("<html><link href='TableRow.css' type=text/css rel='stylesheet'/><link href='BgPhoto.css' type=text/css rel='stylesheet'/>");
		out.println("<form action=NurseEditDelete method=post enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<tr><caption><h3><i>Add Nurse</i></h3></caption></tr>");
		out.println("<tr><td><b><i>Nurse Id:</i></b></td><td><input type=text size=15 name=nid value='"+n.getNurseid()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text size=30 name=nname value='"+n.getNurseName()+"'></td></tr>");
		out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email size=50 name=nemail value='"+n.getNEmail()+"'></td></tr>");
		out.println("<tr><td><b><i>Password</i></b></td><td><input type=password size=30 name=npwd value='"+n.getNpwd()+"' readonly=true></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=text size=50 name=nadd value='"+n.getNAdress()+"'></td></tr>");
		out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text size=15 name=nph value='"+n.getNphone()+"'></td></tr>");
		out.println("<tr><td><b><i>Image:</i></b></td><td><input type=file name=nicon></td><td><img src='pic/"+n.getNIcon()+"' height=100 width=100></td></tr>");
		out.println("<tr><td><input type=submit name=btn value=Edit></td><td><input type=submit name=btn value=Delete></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
	}

}
	}
