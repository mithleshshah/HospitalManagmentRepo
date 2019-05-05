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
 * Servlet implementation class DepartmentEditDelete
 */
@WebServlet("/DepartmentEditDelete")
public class DepartmentEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentEditDelete() {
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
			String deptid=request.getParameter("deptid");
			boolean st=DepartmentDao.deleteById(deptid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Department d=new Department();
			d.setDeptid(request.getParameter("deptid"));
			d.setDeptName(request.getParameter("deptn"));
			d.setDeptDescription(request.getParameter("deptdesc"));
			DepartmentDao.editRecord(d);
		}
		response.sendRedirect("DisplayDepartment");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
