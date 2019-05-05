package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyHomePage
 */
@WebServlet("/MyHomePage")
public class MyHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
        try{
        	String p="<h3><b>Objective</b></h3></br>To promote scientific management of hospital and advancement of health care systems so as to make it rational, responsive and cost efficient, both to consumer and providers. </br>To promote the development of high quality of hospital care in the community and the country so as to provide a satisfactory environment to the patient and also to the doctors for clinical research. </br>To promote a forum for exchange of ideas and information among the health planners, academicians, administrators and general public or improvement of hospital and health services.</br>To make available a model Health Care Institution, which provides not only good health care, but which also provides Training and Research opportunities to Medical and Para-Medical personnel.</br>To make available to women and children, diagnostic Laboratory facilities as well as a Blood Bank for emergencies.";
        String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"<hr color=green>";
       
		out.println("<html><head><meta charset='ISO-8859-1'><title>Hospital Management System</title></head><body>"
				+ "<link href='MyDesign.css' type=text/css rel='stylesheet'/>"
				+ "<div><font size=7><h2><b>Hospital Management System</b></h2></font>"+n+"</div>"
						+ "<table width=100%>"
						+ "<th width=25%></th>"
						+ "<th width=50%>"
						+ "<div id='navContainer'>"
						+ " <ul>"
						+ "<li><a href='DashBoardView' title=Dashboard target=mw>Dashboard</a></li>"
						+ "<li><a href='#' title=Department>Department</a>"
						+ "<div class='subnav'>"
						+ "<ul>"
						+ "<li><a href='DepartmentView.jsp' target=mw>Add Department</a></li>"
						+ "<li><a href='DisplayDepartment' target=mw>List Department</a></li>"
						+ "</ul>"
						+ " </div>"
						+ "</li>"
						+ "<li><a href='#' title='Doctor'>Doctor</a>"
						+ "<div class='subnav'>"
						+ "<ul>"
						+ " <li><a href='DoctorView' target=mw>Add Doctor</a></li>"
						+ " <li><a href='DoctorList' target=mw>List Doctor</a></li>"
						+ " </ul>"
						+ "</div>"
						+ "</li>"
						+ "<li><a href='#' title='Patient'>Patient</a>"
						+ "<div class='subnav'>"
						+ "<ul>"
						+ "<li><a href='PatientView.jsp' target=mw>Add Patient</a></li>"
						+ "<li><a href='PatientList' target=mw>List Patient</a></li>"
						+ "</ul>"
						+ "</div>"
						+ "</li>"
						+ "<li><a href='#' title='Nurse'>Nurse</a>"
						+ "<div class='subnav'>"
						+ "<ul>"
						+ "<li><a href='NurseView.jsp' target=mw>Add Nurse</a></li>"
						+ "<li><a href='NurseList' target=mw>List Nurse</a></li>"
						+ "</ul>"
						+ "</div>"
						+ "</li>"
						+ "<li><a href='#' title='Laboratorist'>Laboratorist</a>"
						+ "<div class='subnav'>"
						+ "<ul>"
						+ "<li><a href='LaboratoristView.jsp' target=mw>Add Laboratorist</a></li>"
					+ "<li><a href='LaboratoristList' target=mw>List Laboratorist</a></li>"
					+ "</ul>"
					+ " </div>"
					+ "</li>"
					+ "<li><a href='#' title='Accountant'>Accountant</a>"
						+ "<div class='subnav'>"
						+ "<ul>"
						+ "<li><a href='AccountantView.jsp' target=mw>Add Accountant</a></li>"
						+ " <li><a href='AccountantList' target=mw>List Accountant</a></li>"
								+ " </ul>"
								+ "</div>"
								+ " </li>"
								+ " <li><a href='ProfileView.jsp' target=mw>Profile</a></li>"
										+ "<li><a href='UserLogout' title='Log Out'>Log Out</a></li>"
												+ "</ul>"
												+ "</div>"
												+ "<!-- Main Navigation Part End Here -->"
												+ "</th>"
												+ "<th width=25%></th>"
												+ "<tr>"
												+ "<td width=25% valign=top align='center'><img src='pic/dna.jpg' height=800 width=220></td>"
												+ "<td width=50%><iframe width=900 height=800 frameborder=0 name=mw></iframe></td>"
														+ "<td width=25%><marquee direction='up'>"+p+"</marquee></td>"
																+ "</tr></table>"
																+ "<div class='footer'>"
																+ " <div class='footer-1'><span class='footer-text'><b>Contact Us</b></span><br />"
																+ "<hr color='#9d9d9d' />"
																+ "<span class='footer-small-text'>Hospital managment System <br />"
																+ "Vikrant Instt. of Technology, <br />"
																+ "Gwalior, INDIA<br /><br />"
																+ "<span class='footer-link'><a href='contact_us.html'>Contact Us</a></span>"
																+ "</span></div>"
																+ " <div class='footer-1'><span class='footer-text'><b>Quick Links</b></span><br />"
																+ "<hr color='#9d9d9d' />"
																+ "<span class='footer-link'><a href='DAppointmentView' target=mw>Appointment</a></span> <br />"
																+ "<span class='footer-link'><a href='AddMedicinecategory.jsp' target=mw>Medicine Category</a></span><br />"
																+ "<span class='footer-link'><a href='PrescriptionView' target=mw>Prescription</a></span><br />"
																+ "<span class='footer-link'><a href='MedView' target=mw>Medicine</a></span><br />"
																+ "<span class='footer-link'><a href='AddBed.jsp' target=mw>Bed</a></span><br />"
																+ "<span class='footer-link'><a href='AddInvoice.jsp' target=mw>Invoice</a></span><br />"
																+ "<span class='footer-link'><a href='DBloodBank.jsp' target=mw>Blood Bank</a></span></div>"
																+ "<div class='footer-1'><span class='footer-text'><b>Other Links</b></span><br />"
																+ "<hr color='#9d9d9d' /><span class='footer-link'><a href='AppointmentList' target=mw>Appointment List</a></span> <br />"
																+ "<span class='footer-link'><a href='PrescriptionList' target=mw>Precription List</a></span><br />"
																+ "<span class='footer-link'><a href='MedCatList' target=mw>Medicine Category List</a></span><br />"
																+ "<span class='footer-link'><a href='BedList' target=mw>Bed List</a></span><br />"
																+ "<span class='footer-link'><a href='MedicineList' target=mw>Medicine</a></span><br />"
																		+ "<span class='footer-link'><a href='DDonorList' target=mw>Donor List</a></span><br />"
																				+ "<span class='footer-link'><a href='ReportList' target=mw>Diagnosis Report</a></span></div>"
																						+ "<div class='footer-2'><span class='footer-text'><b>Follow us on</b></span><br />"
																						+ "<hr color='#9d9d9d' />"
																								+ "<ul class='flipboard'>"
																										+ "<li><a href='https://www.facebook.com/Mithlesh.shah2' target='_blank'><span>Facebook</span></a></li>"
																										+ "<li><a href='https://twitter.com/mithleshshah84' target='_blank'><span>Twitter</span></a></li>"
																										+ "<li><a href='https://plus.google.com/mithleshshah84' target='_blank'><span>Google plus</span></a></li>"
																										+ "</ul></div>"
																										+ "</div>"
																										+ "</body>"
																										+"</html>");
        }catch(Exception e)
	        {
	        	response.sendRedirect("LoginPage");
	        }
	}

}
