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
 * Servlet implementation class NurseAction
 */
@WebServlet("/NurseAction")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class NurseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String nid=request.getParameter("nid");
			boolean st=NurseDao.deleteById(nid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
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
		}
		response.sendRedirect("NurseList");
	}

}
