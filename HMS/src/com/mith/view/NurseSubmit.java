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

import com.mith.dao.NurseDao;
import com.mith.model.Nurse;

/**
 * Servlet implementation class NurseSubmit
 */
@WebServlet("/NurseSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class NurseSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 out.println("<a href=NurseView>Click Here to Add More Nurse</a>");
		Nurse n=new Nurse();
		n.setNurseid(request.getParameter("nid"));
		n.setNurseName(request.getParameter("nname"));
		n.setNEmail(request.getParameter("nemail"));
		n.setNpwd(request.getParameter("npwd"));
		n.setNAdress(request.getParameter("nadd"));
		n.setNphone(request.getParameter("nph"));
		try{
			Part part=request.getPart("nicon");
			String savepath="C:/Users/Mithlesh Shah/Documents/Workspace1/HMS/WebContent/pic";
			FileUpload F=new FileUpload(part,savepath);
			n.setNIcon(F.filename);
		}catch(Exception e){
			System.out.println(e);
		}
		
		out.println("<html>");
		boolean st=NurseDao.addNewRecord(n);
		if(st)
		{ response.sendRedirect("NurseList"); }
		else
		{
			out.println("<h4><font color=red>Fail to Register Nurse.....</font></h4>");	
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
