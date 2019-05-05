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
 * Servlet implementation class AppointmentSubmit
 */
@WebServlet("/AppointmentSubmit")
public class AppointmentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=DAppointmentView>Click Here to Add More Appointment</a>");
		DAppointment a=new DAppointment();
		a.setApno(request.getParameter("apno"));
		a.setDoctor(request.getParameter("dname"));
		a.setPatient(request.getParameter("pname"));
		a.setApdate(request.getParameter("adate"));
		out.println("<html>");
		boolean st=DAppointmentDao.addNewRecord(a);
		if(st)
		{ response.sendRedirect("AppointmentList");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Register Appointment.....</font></h4>");	
		}
	 	out.flush();
	}

}
