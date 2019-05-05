package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mith.dao.LaboratoristDao;
import com.mith.model.Laboratorist;

/**
 * Servlet implementation class LaboratoristSubmit
 */
@WebServlet("/LaboratoristSubmit")
public class LaboratoristSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaboratoristSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=LaboratoristView.jsp>Click Here to Add More Laboratorist</a>");
		Laboratorist l=new Laboratorist();
		l.setLaboratoristId(request.getParameter("lid"));
		l.setLName(request.getParameter("lname"));
		l.setLEmail(request.getParameter("lemail"));
		l.setLpwd(request.getParameter("lpwd"));
		l.setLadd(request.getParameter("ladd"));
		l.setLph(request.getParameter("lph"));
		out.println("<html>");
		boolean st=LaboratoristDao.addNewRecord(l);
		if(st)
		{ response.sendRedirect("LaboratoristList");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Register Laboratorist.....</font></h4>");	
		}
	 	out.flush();}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
