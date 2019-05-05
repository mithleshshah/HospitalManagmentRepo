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

import com.mith.dao.DepartmentDao;
import com.mith.dao.DoctorDao;
import com.mith.model.Department;
import com.mith.model.Doctor;

/**
 * Servlet implementation class DoctorEditDelete
 */
@WebServlet("/DoctorEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class DoctorEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String did=request.getParameter("did");
			boolean st=DoctorDao.deleteById(did);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Doctor d=new Doctor();
			d.setDoctorid(request.getParameter("did"));
			d.setDocName(request.getParameter("dname"));
			d.setDEmail(request.getParameter("demail"));
			d.setDpwd(request.getParameter("dpwd"));
			d.setDAdress(request.getParameter("dadd"));
			d.setDphone(request.getParameter("dph"));
			d.setDepartment(request.getParameter("ddept"));
			//d.setDIcon(request.getParameter("dicon"));
			try{
				Part part=request.getPart("dicon");
				String savepath="C:/Users/Mithlesh Shah/Documents/Workspace1/HMS/WebContent/pic";
				FileUpload F=new FileUpload(part,savepath);
				d.setDIcon(F.filename);
			}catch(Exception e){
				System.out.println(e);
			}
			DoctorDao.editRecord(d);
		}
		response.sendRedirect("DoctorList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
