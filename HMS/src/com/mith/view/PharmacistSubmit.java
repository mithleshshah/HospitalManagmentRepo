package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.PharmacistDao;
import com.mith.model.Pharmacist;


/**
 * Servlet implementation class PharmacistSubmit
 */
@WebServlet("/PharmacistSubmit")
public class PharmacistSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacistSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Pharmacist p=new Pharmacist();
		p.setPharmacistId(request.getParameter("phid"));
		p.setPhName(request.getParameter("phname"));
		p.setPhEmail(request.getParameter("phemail"));
		p.setPhpwd(request.getParameter("phpwd"));
		p.setPhadd(request.getParameter("phadd"));
		p.setPhph(request.getParameter("phph"));
		out.println("<html>");
		boolean st=PharmacistDao.addNewRecord(p);
		if(st)
		{ out.println("<h4><font color=green>Pharmacist Registered...<br><a href=PharmacistView.jsp>Click Here to Add More Pharmacist</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Register Pharmacist.....</font></h4>");	
		}
	 	out.flush();}

}
