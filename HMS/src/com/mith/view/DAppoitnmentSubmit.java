package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.mith.dao.AppointmentDao;
import com.mith.dao.DoctorDao;
import com.mith.model.Appointment;
import com.mith.model.Doctor;

/**
 * Servlet implementation class DAppoitnmentSubmit
 */
@WebServlet("/DAppoitnmentSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class DAppoitnmentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DAppoitnmentSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Appointment a=new Appointment();
		a.setAid(request.getParameter("aid"));
		a.setName(request.getParameter("dname"));
		a.setEmail(request.getParameter("demail"));
		a.setAdress(request.getParameter("dadd"));
		a.setPhone(request.getParameter("dph"));
		a.setDepartment(request.getParameter("ddept"));
		a.setDate(request.getParameter("ddate"));
		try{
			Part part=request.getPart("dicon");
			String savepath="C:/Users/Mithlesh Shah/Documents/Workspace1/HMS/WebContent/usrpic";
			FileUpload F=new FileUpload(part,savepath);
			a.setIcon(F.filename);
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		boolean st=AppointmentDao.addNewRecord(a);
		out.println("<html>");
		if(st)
		{ response.sendRedirect("DAppointmentList");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Register Request.....</font></h4>");	
		}
	 	out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
