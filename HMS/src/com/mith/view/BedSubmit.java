package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.NBedDao;
import com.mith.model.NBed;

/**
 * Servlet implementation class BedSubmit
 */
@WebServlet("/BedSubmit")
public class BedSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BedSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=AddBed.jsp>Click Here to Add More Bed</a>");
		 NBed b=new NBed();
		  b.setBedNo(request.getParameter("bno"));
		  b.setWard(request.getParameter("wtyp"));
		  b.setDescription(request.getParameter("desc"));
		  out.println("<html>");
		  Boolean st=NBedDao.addNewRecord(b);
		  if(st)
			{ response.sendRedirect("BedList");
			}
			else
			{
				out.println("<h4><font color=red>Fail to Add Bed.....</font></h4>");	
			}
		 	out.flush();
	}

}
