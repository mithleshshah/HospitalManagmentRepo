package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.LaboratoristDao;
import com.mith.model.Laboratorist;


/**
 * Servlet implementation class LaboratoristEditDelete
 */
@WebServlet("/LaboratoristEditDelete")
public class LaboratoristEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaboratoristEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String lid=request.getParameter("lid");
			boolean st=LaboratoristDao.deleteById(lid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Laboratorist l=new Laboratorist();
			l.setLaboratoristId(request.getParameter("lid"));
			l.setLName(request.getParameter("lname"));
			l.setLEmail(request.getParameter("lemail"));
			l.setLpwd(request.getParameter("lpwd"));
			l.setLadd(request.getParameter("ladd"));
			l.setLph(request.getParameter("lph"));
			
			LaboratoristDao.editRecord(l);
		}
		response.sendRedirect("LaboratoristList");
		}

}
