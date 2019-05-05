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
 * Servlet implementation class PharmacistEditDelete
 */
@WebServlet("/PharmacistEditDelete")
public class PharmacistEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacistEditDelete() {
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
			String phid=request.getParameter("phid");
			boolean st=PharmacistDao.deleteById(phid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Pharmacist p=new Pharmacist();
			p.setPharmacistId(request.getParameter("phid"));
			p.setPhName(request.getParameter("phname"));
			p.setPhEmail(request.getParameter("phemail"));
			p.setPhpwd(request.getParameter("phpwd"));
			p.setPhadd(request.getParameter("phadd"));
			p.setPhph(request.getParameter("phph"));
			
			PharmacistDao.editRecord(p);
		}
		
		response.sendRedirect("PharmacistList");
	}

}
