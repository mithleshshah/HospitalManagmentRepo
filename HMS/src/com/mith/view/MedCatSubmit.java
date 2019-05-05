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
 * Servlet implementation class MedCatSubmit
 */
@WebServlet("/MedCatSubmit")
public class MedCatSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedCatSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=AddMedicinecategory.jsp>Click Here to Add Medicine Category</a>");
		 MedCategory m=new MedCategory();
		  m.setMedCatId(request.getParameter("mcid"));
		  m.setMedCat(request.getParameter("medc"));
		  m.setMedDesc(request.getParameter("meddesc"));
		  out.println("<html>");
		  Boolean st= MCategoryDao.addNewRecord(m);
		  if(st)
			{  response.sendRedirect("MedCatList");}
			else
			{
				out.println("<h4><font color=red>Fail to Add Medicine Category.....</font></h4>");	
			}
		 	out.flush();
	}

}
