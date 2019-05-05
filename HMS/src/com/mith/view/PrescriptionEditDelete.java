package com.mith.view;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.mith.dao.PrescriptionDao;
import com.mith.model.Prescription;


/**
 * Servlet implementation class PrescriptionEditDelete
 */
@WebServlet("/PrescriptionEditDelete")
public class PrescriptionEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionEditDelete() {
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
			String pno=request.getParameter("pno");
			boolean st=PrescriptionDao.deleteById(pno);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Prescription p=new Prescription();
			p.setPno(request.getParameter("pno"));
			p.setPdname(request.getParameter("dname"));
			p.setPpname(request.getParameter("pname"));
			p.setPcs(request.getParameter("chp"));
			p.setPmd(request.getParameter("mdp"));
			p.setPmdp(request.getParameter("mdpp"));
			p.setPdesc(request.getParameter("desp"));
			p.setPdate(request.getParameter("pdate"));	
			PrescriptionDao.editRecord(p);
		}
		response.sendRedirect("PrescriptionList");
		}

}
