package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.MedicineDao;
import com.mith.model.Medicine;

/**
 * Servlet implementation class MedicineSubmit
 */
@WebServlet("/MedicineSubmit")
public class MedicineSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=MedView>Click Here to Add More Medicine</a>");
		 Medicine m=new Medicine();
		 m.setMedNo(request.getParameter("mno"));
		 m.setMName(request.getParameter("mname"));
		 m.setMCategory(request.getParameter("mcname"));
		 m.setMdescription(request.getParameter("mdesc"));
		 m.setMPrice(request.getParameter("mprice"));
		 m.setMCName(request.getParameter("cname"));
		 m.setMStatus(request.getParameter("mstatus"));
		 
		 out.println("<html>");
			boolean st=MedicineDao.addNewRecord(m);
			if(st)
			{ response.sendRedirect("MedicineList");}
			else
			{
				out.println("<h4><font color=red>Fail to Add Medicinet.....</font></h4>");	
			}
		 	out.flush();
	}

}
