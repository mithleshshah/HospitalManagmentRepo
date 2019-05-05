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
 * Servlet implementation class PrescriptionSubmit
 */
@WebServlet("/PrescriptionSubmit")
public class PrescriptionSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescriptionSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Prescription p=new Prescription();
		p.setPno(request.getParameter("pno"));
		p.setPdname(request.getParameter("dname"));
		p.setPpname(request.getParameter("pname"));
		p.setPcs(request.getParameter("chp"));
		p.setPmd(request.getParameter("mdp"));
		p.setPmdp(request.getParameter("mdpp"));
		p.setPdesc(request.getParameter("desp"));
		p.setPdate(request.getParameter("pdate"));	
		boolean st=PrescriptionDao.addNewRecord(p);
		out.println("<html>");
		if(st)
		{ out.println("<h4><font color=green>Prescription Registered...<br><a href=PrescriptionView>Click Here to Add More Prescription</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Register Prescription.....</font></h4>");	
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
