package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.BedAllotmentDao;
import com.mith.model.BedAllotment;


/**
 * Servlet implementation class DBedAllotmentEditDelete
 */
@WebServlet("/DBedAllotmentEditDelete")
public class DBedAllotmentEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBedAllotmentEditDelete() {
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
			boolean st=BedAllotmentDao.deleteById(bno);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			 BedAllotment b=new BedAllotment();
			  b.setBno(request.getParameter("bno"));
			  b.setWard(request.getParameter("wno"));
			  b.setPatient(request.getParameter("pname"));
			  b.setAllotmentDate(request.getParameter("dbadate"));
			  b.setDischargeDate(request.getParameter("dbddate"));
			
			BedAllotmentDao.editRecord(b);
		}
		response.sendRedirect("BedAllotmentList");
	}

}
