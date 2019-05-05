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

import com.mith.dao.DoctorDao;
import com.mith.dao.PatientDao;
import com.mith.model.Doctor;
import com.mith.model.Patient;

/**
 * Servlet implementation class PatientSubmit
 */
@WebServlet("/PatientSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class PatientSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 out.println("<h4><font color=green>Patient Registered...<br><a href=DoctorView>Click Here to Add More Patient</a></font></h4>");
		Patient p=new Patient();
		p.setPatientid(request.getParameter("pid"));
		p.setPName(request.getParameter("pname"));
		p.setPEmail(request.getParameter("pemail"));
		p.setPpwd(request.getParameter("ppwd"));
		p.setPAdress(request.getParameter("padd"));
		p.setPphone(request.getParameter("pph"));
		p.setPsex(request.getParameter("gend"));
		p.setPdob(request.getParameter("pbd"));
		p.setPage(request.getParameter("page"));
		p.setPbg(request.getParameter("pbg"));
		try{
			Part part=request.getPart("picon");
			String savepath="C:/Users/Mithlesh Shah/Documents/Workspace1/HMS/WebContent/pic";
			FileUpload F=new FileUpload(part,savepath);
			p.setPicon(F.filename);
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		boolean st=PatientDao.addNewRecord(p);
		out.println("<html>");
		if(st)
		{  response.sendRedirect("PatientList");}
		else
		{
			out.println("<h4><font color=red>Fail to Register Patient.....</font></h4>");	
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
