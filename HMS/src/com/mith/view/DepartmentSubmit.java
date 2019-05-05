package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DepartmentDao;
import com.mith.model.Department;

/**
 * Servlet implementation class DepartmentSubmit
 */
@WebServlet("/DepartmentSubmit")
public class DepartmentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=DepartmentView.jsp>Click Here to Add More department</a>");
		Department d=new Department();
		d.setDeptid(request.getParameter("deptid"));
		d.setDeptName(request.getParameter("deptn"));
		d.setDeptDescription(request.getParameter("deptdesc"));
		boolean st=DepartmentDao.addNewRecord(d);
		out.println("<html>");
		if(st)
		{ response.sendRedirect("DisplayDepartment");
		}
		else
		{
			out.println("<h4><font color=red>Fail to Submit department.....</font></h4>");	
		}
	 	out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
