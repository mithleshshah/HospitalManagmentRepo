package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashBoardView
 */
@WebServlet("/DashBoardView")
public class DashBoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<center><table border=1 cellpadding=10 cellspacing=25>");
		out.println("<tr><td><a href=DepartmentView.jsp><img src='dpic/department.png' width=200 height=200></td><td><a href=DoctorView><img src='dpic/doctor.jpg' width=200 height=200></td><td><a href=PatientView.jsp><img src='dpic/patient.jpg' width=200 height=200></td></tr>");
		out.println("<tr><td><a href=NurseView.jsp><img src='dpic/nurse.jpg' width=200 height=200></td><td><a href=LaboratoristView.jsp><img src='dpic/laboratorist.jpg' width=200 height=200></td><td><a href=AccountantView.jsp><img src='dpic/accountant.png' width=200 height=200></td></tr>");
		out.println("<tr><td><a href=DBloodBank.jsp><img src='dpic/blood.png' width=200 height=200></td><td><a href=ManagePayment.jsp><img src='dpic/payment.png' width=200 height=200></td><td><a href=AddBed.jsp><img src='dpic/bed.png' width=200 height=200></td></tr>");
		out.println("<tr><td><a href=AddDiagnosisReport.jpg><img src='dpic/report.png' width=200 height=200></td><td><a href=PharmacistView.jsp><img src='dpic/pharmacist.jpg' width=200 height=200></td><td><a href=MedView><img src='dpic/medicine.png' width=200 height=200></td></tr>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
