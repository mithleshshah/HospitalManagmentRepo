package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.MCategoryDao;
import com.mith.model.MedCategory;


/**
 * Servlet implementation class MCatEditDelete
 */
@WebServlet("/MCatEditDelete")
public class MCatEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MCatEditDelete() {
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
			String mcid=request.getParameter("mcid");
			boolean st=MCategoryDao.deleteById(mcid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			 MedCategory m=new MedCategory();
			  m.setMedCatId(request.getParameter("mcid"));
			  m.setMedCat(request.getParameter("medc"));
			  m.setMedDesc(request.getParameter("meddesc"));
			  
			  MCategoryDao.editRecord(m);
		
		}
		response.sendRedirect("MedCatList");
		}

}
