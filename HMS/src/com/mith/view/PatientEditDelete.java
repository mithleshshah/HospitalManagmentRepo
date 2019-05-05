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
 * Servlet implementation class PatientEditDelete
 */
@WebServlet("/PatientEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class PatientEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String pid=request.getParameter("pid");
			boolean st=PatientDao.deleteById(pid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
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
			PatientDao.editRecord(p);
		}
		response.sendRedirect("PatientList");
	}

}
