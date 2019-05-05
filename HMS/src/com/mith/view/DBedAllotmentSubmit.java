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
 * Servlet implementation class DBedAllotmentSubmit
 */
@WebServlet("/DBedAllotmentSubmit")
public class DBedAllotmentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBedAllotmentSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=BedAllotmentView>Click Here to Add More Allotment</a>");
		 BedAllotment b=new BedAllotment();
		  b.setBno(request.getParameter("bno"));
		  b.setWard(request.getParameter("wno"));
		  b.setPatient(request.getParameter("pname"));
		  b.setAllotmentDate(request.getParameter("dbadate"));
		  b.setDischargeDate(request.getParameter("dbddate"));
		out.println("<html>");
		boolean st=BedAllotmentDao.addNewRecord(b);
		if(st)
		{ response.sendRedirect("BedAllotmentList");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Register Allotment.....</font></h4>");	
		}
	 	out.flush();
	 	}

}
