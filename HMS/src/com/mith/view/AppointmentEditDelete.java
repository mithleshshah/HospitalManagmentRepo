package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DAppointmentDao;
import com.mith.model.DAppointment;

/**
 * Servlet implementation class AppointmentEditDelete
 */
@WebServlet("/AppointmentEditDelete")
public class AppointmentEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentEditDelete() {
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
			String apno=request.getParameter("apno");
			boolean st=DAppointmentDao.deleteById(apno);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			DAppointment a=new DAppointment();
			a.setApno(request.getParameter("apno"));
			a.setDoctor(request.getParameter("dname"));
			a.setPatient(request.getParameter("pname"));
			a.setApdate(request.getParameter("adate"));
			
			DAppointmentDao.editRecord(a);
		}
		response.sendRedirect("AppointmentList");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
