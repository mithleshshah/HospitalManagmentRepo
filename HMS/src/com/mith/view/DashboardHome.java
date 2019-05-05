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
 * Servlet implementation class DashboardHome
 */
@WebServlet("/DashboardHome")
public class DashboardHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardHome() {
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
		out.println("<script type=text/javascript src=/asset/js/gooleapies.js></script>");
		HttpSession ses=request.getSession();
        try{
        String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=UserLogout>Logout</a></b></i></h4><hr color=green>";
        out.println(n);		
        	
        }
        catch(Exception e)
        {
        	response.sendRedirect("LoginPage");
        }out.println("<table>");
        out.println("<tr>");
        out.println("<td valign=top>");
        out.println("<div class=sidemenu><a href=DepartmentView.jsp target=mw>Department</a><div>");
        out.println("<div class=sidemenu><a href=DoctorView target=mw>Doctor</a><div>");
        out.println("<a href=PatientView.jsp target=mw>Patient</a><br>");
        out.println("<a href=NurseView.jsp target=mw>Nurse</a><br>");
        out.println("<a href=PharmacistView.jsp target=mw>Pharmacist</a><br>");
        out.println("<a href=LaboratoristView.jsp target=mw>Laboratorist</a><br>");
        out.println("<a href=AccountantView.jsp target=mw>Accountant</a><br>");
        out.println("<a href=ProfileView.jsp target=mw>Profile</a><br>");
        out.println("</td>");
        out.println("<td><iframe width=800 height=800 frameborder=0 name=mw></iframe></td></tr></table></html>"); 
        out.flush();
	}

}
