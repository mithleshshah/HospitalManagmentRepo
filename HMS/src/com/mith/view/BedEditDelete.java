package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.AccountantDao;
import com.mith.dao.NBedDao;
import com.mith.model.NBed;

/**
 * Servlet implementation class BedEditDelete
 */
@WebServlet("/BedEditDelete")
public class BedEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BedEditDelete() {
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
			String bno=request.getParameter("bno");
			boolean st=NBedDao.deleteById(bno);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			 NBed b=new NBed();
			  b.setBedNo(request.getParameter("bno"));
			  b.setWard(request.getParameter("wtyp"));
			  b.setDescription(request.getParameter("desc"));
			NBedDao.editRecord(b);
		}
		response.sendRedirect("BedList");
	}

}
