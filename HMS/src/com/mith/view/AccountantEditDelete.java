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

import com.mith.dao.AccountantDao;
import com.mith.model.Accountant;

/**
 * Servlet implementation class AccountantEditDelete
 */
@WebServlet("/AccountantEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class AccountantEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String acid=request.getParameter("acid");
			boolean st=AccountantDao.deleteById(acid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Accountant a=new Accountant();
			a.setAccountantId(request.getParameter("acid"));
			a.setAName(request.getParameter("acname"));
			a.setAEmail(request.getParameter("acemail"));
			a.setApwd(request.getParameter("acpwd"));
			a.setAadd(request.getParameter("acadd"));
			a.setAph(request.getParameter("acph"));
			try{
				Part part=request.getPart("aicon");
				String savepath="C:/Users/Mithlesh Shah/Documents/Workspace1/HMS/WebContent/pic";
				FileUpload F=new FileUpload(part,savepath);
				a.setAicon(F.filename);
			}catch(Exception e){
				System.out.println(e);
			}
			AccountantDao.editRecord(a);
		}
		response.sendRedirect("AccountantList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
